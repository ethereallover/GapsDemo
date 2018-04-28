package com.hundsun.gaps.flowexecutor.factory.scanner;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.hundsun.gaps.flowexecutor.function.interfaces.IResourceScanAware;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

/**
 * 表定义扫描器
 * 
 * @author fanjr15662@hundsun.com
 * @date 2018年4月3日
 */
@Scope
@Service
public class GapsTableDefineScanner implements IResourceScanAware, InitializingBean {

	private final Logger logger = LoggerFactory.getLogger(GapsTableDefineScanner.class);

	private final static String SUFFIX = ".table";

	private Resource[] resources;

	private static Map<String, String> tableMap;

	public static boolean checkTableName(String tableName) {
		return tableMap.containsKey(tableName.toUpperCase());
	}

	@Override
	public String getSuffix() {
		return SUFFIX;
	}

	@Override
	public void setResources(Resource[] resources) {
		this.resources = resources;
	}

	@Override
	public void afterPropertiesSet() {
		tableMap = new HashMap<>();

		XStream xstream = new XStream(new DomDriver());
		XStream.setupDefaultSecurity(xstream);
		xstream.autodetectAnnotations(true);
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.setClassLoader(XstreamScanner.class.getClassLoader());
		xstream.processAnnotations(TablesModel.class);
		xstream.addPermission(AnyTypePermission.ANY);
		xstream.ignoreUnknownElements();
		xstream.ignoreUnknownElements("description");

		for (Resource xmlResource : resources) {
			try (InputStream input = xmlResource.getInputStream()) {
				TablesModel xml = (TablesModel) xstream.fromXML(input);
				xml.getTableList().forEach((tableModel) -> {
					tableMap.put(tableModel.getName().toUpperCase(), tableModel.getTitle());
				});
			} catch (IOException e) {
				// 失败也需要继续解析
				logger.warn("表定义文件读取发生异常,文件信息:{}", xmlResource.getDescription(), e);
			}
		}
	}

	@XStreamAlias("tables")
	private static class TablesModel {
		@XStreamAlias("table")
		@XStreamImplicit(itemFieldName = "table")
		List<TableModel> tableList;

		public List<TableModel> getTableList() {
			return tableList;
		}

		@SuppressWarnings("unused")
		public void setTableList(List<TableModel> tableList) {
			this.tableList = tableList;
		}

	}

	@XStreamAlias("table")
	private class TableModel {
		@XStreamAlias("name")
		@XStreamAsAttribute
		private String name;

		@XStreamAlias("title")
		@XStreamAsAttribute
		private String title;

		public String getName() {
			return name;
		}

		@SuppressWarnings("unused")
		public void setName(String name) {
			this.name = name;
		}

		public String getTitle() {
			return title;
		}

		@SuppressWarnings("unused")
		public void setTitle(String title) {
			this.title = title;
		}
	}

}
