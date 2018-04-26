package org.tinygroup.studio.eclipse.database.ui.gen;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.tinygroup.studio.eclipse.database.ui.Activator;
import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNLogEntry;
import org.tmatesoft.svn.core.SVNLogEntryPath;
import org.tmatesoft.svn.core.SVNNodeKind;
import org.tmatesoft.svn.core.SVNProperties;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class SVNUtils {
	
	private static final ILog log = Activator.getDefault().getLog();
	
	private String userName;
	
	private String password;
	
	private String url;
	
	private SVNClientManager clientManager;
	
	private SVNUpdateClient updateClient;
	
	private List<SVNDirEntry> dirs = new ArrayList<SVNDirEntry>();
	
	static {
		SVNRepositoryFactoryImpl.setup();
	}
	
	public SVNUtils(String userName,String password){
		init(userName, password);
	}
	
	public SVNUtils(String userName,String password,String url){
		this(userName,password);
		this.url = url;
	}
	
	
	private void init(String userName,String password){
		DefaultSVNOptions options = new DefaultSVNOptions();
		options.setAuthStorageEnabled(false);
		clientManager = SVNClientManager.newInstance(options, userName, password);
		updateClient = clientManager.getUpdateClient();
		updateClient.setIgnoreExternals(true);
	}
	
	/**获取文档内容
     * @param url
     * @return
     */
    public String checkoutFileToString(String url) throws SVNException {
    	log.log(new Status(IStatus.INFO, Activator.PLUGIN_ID, "Check out svn repository file-----start"));
        
    	SVNRepository repository = createRepository(url);
        SVNDirEntry entry = repository.getDir("", -1, false, null);
        int size = (int)entry.getSize();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(size);
        SVNProperties properties = new SVNProperties();
        repository.getFile("", -1, properties, outputStream);
        String doc = new String(outputStream.toByteArray(), Charset.forName("utf-8"));
        
       log.log(new Status(IStatus.INFO, Activator.PLUGIN_ID, "Check out svn repository file-----end"));
        return doc;
    }
    
    private SVNRepository createRepository(String url)  throws SVNException{
    	 return clientManager.createRepository(SVNURL.parseURIEncoded(url), true);
    }
    
    /**检查路径是否存在
     * @param url
     * @return 1：存在    0：不存在   -1：出错
     * @throws SVNException 
     */
    public int checkPath(String url) throws SVNException{
        SVNRepository repository = createRepository(url);
        SVNNodeKind nodeKind;
        nodeKind = repository.checkPath("", -1);
        boolean result = nodeKind == SVNNodeKind.NONE ? false : true;
        if(result){
        	return 1;
        }
        return 0;
    }
    
    /**列出指定SVN 地址目录下的子目录
     * @param url
     * @return
     */
    public List<SVNDirEntry> listFolder(String url) throws SVNException {
        if(checkPath(url)==1){
            SVNRepository repository = createRepository(url);
            @SuppressWarnings("unchecked")
			Collection<SVNDirEntry> list = repository.getDir("", -1, null, (List<SVNDirEntry>)null);
            Iterator<SVNDirEntry> iterator = list.iterator();
            while(iterator.hasNext()){
            	SVNDirEntry dirEntry = iterator.next();
            	if(dirEntry.getKind() == SVNNodeKind.DIR ){
            		listFolder(dirEntry.getURL().toString());
            	}
            	if(dirEntry.getName().endsWith(".table")){
            		dirs.add(dirEntry);
            	}
            }
            return dirs;
        }
        return null;
    }
    
    /**
     * 将xml文件转换成模型对象
     * @param input
     * @param loader
     * @param classes
     * @return
     */
    public Object read(String input, ClassLoader loader,
			Class<?>[] classes) {
		XStream xstream = new XStream(new DomDriver());
		xstream.autodetectAnnotations(true);
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.processAnnotations(classes);
		xstream.setClassLoader(loader);
		return xstream.fromXML(input);
	}
    
    /**
     * 获取指定历史版本的文件内容
     * @param url
     * @param version
     * @return
     * @throws SVNException
     */
    public String getFileByVersion(String url,String version) throws SVNException{
		SVNRepository repository = createRepository(url);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        SVNProperties properties = new SVNProperties();
        repository.getFile("", SVNRevision.parse(version).getNumber(), properties, outputStream);

        return new String(outputStream.toByteArray(), Charset.forName("utf-8"));
        
	}
    
    /**
     * 根据指定url获取修改日志记录
     * @param url
     * @param filterPaths 过滤目录(不为空时，只获取该目录下的日志记录信息)
     * @throws SVNException
     */
    public List<SVNLogEntry> getVersionList(String url,String[] filterPaths) throws SVNException{
		SVNRepository repository = createRepository(url);
		
		List<SVNLogEntry> svnLogList = new ArrayList<SVNLogEntry>();
		
		@SuppressWarnings("unchecked")
		Collection<SVNLogEntry> logEntries = repository.log(filterPaths,null,0,-1,true,true);
		Iterator<SVNLogEntry> iterator = logEntries.iterator();
		while(iterator.hasNext()){
			SVNLogEntry logEntry = iterator.next();
			Map<String, SVNLogEntryPath> changedPaths = logEntry.getChangedPaths();
			if(changedPaths.size() > 0){
				Set<String> entrySet = changedPaths.keySet();
				Iterator<String> iter_changed = entrySet.iterator();
				while(iter_changed.hasNext()){
					SVNLogEntryPath entryPath = (SVNLogEntryPath) changedPaths.get(iter_changed.next());
					if(entryPath.getPath().endsWith(".table") && entryPath.getPath().indexOf(filterPaths[0]) > 0){
						svnLogList.add(logEntry);
					}
				}
			}
		}
		return svnLogList;
	}
    
    public List<String> getSVNLogEntryInfo(SVNLogEntry logEntry){
    	List<String> infos = new ArrayList<String>();
    	infos.add(String.valueOf(logEntry.getRevision()));
    	infos.add(logEntry.getAuthor());
    	infos.add(formatDate(logEntry.getDate()));
    	if(!logEntry.getMessage().isEmpty()){
    		infos.add(logEntry.getMessage());
    	}else {
    		infos.add("");
    	}
    	return infos;
    }
    
    public String formatDate(Date date){
    	SimpleDateFormat formator = new SimpleDateFormat("yyyy年MM月dd日  HH时mm分ss秒");
    	return formator.format(date);
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
