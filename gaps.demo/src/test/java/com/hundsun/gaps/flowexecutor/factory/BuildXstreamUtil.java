package com.hundsun.gaps.flowexecutor.factory;

import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

@SuppressWarnings("unused")
public class BuildXstreamUtil {
	private static Logger log = LoggerFactory.getLogger(BuildXstreamUtil.class);
	private static XStream xstream;

	public static XStream getXstream() {
		return xstream;
	}

	public static XStream build(ClassLoader classLoader, String xmlResource) {
		try {
			xstream = new XStream(new DomDriver("UTF-8"));
			XStream.setupDefaultSecurity(xstream);
			xstream.autodetectAnnotations(true);
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.setClassLoader(classLoader);
			xstream.ignoreUnknownElements();
			xstream.addPermission(AnyTypePermission.ANY);
			readXml(classLoader, xmlResource);
		} catch (Exception e) {
			log.error(String.format("processing file <%s>", "gaps4j-xstream.xml"), e);
		}
		return xstream;
	}

	private static void readXml(ClassLoader classLoader, String xmlResource) {
		XStream temp = new XStream(new DomDriver());
		XStream.setupDefaultSecurity(temp);
		temp.autodetectAnnotations(true);
		temp.setMode(XStream.NO_REFERENCES);
		temp.setClassLoader(BuildXstreamUtil.class.getClassLoader());
		temp.processAnnotations(XstreamXml.class);
		temp.addPermission(AnyTypePermission.ANY);
		InputStream input = classLoader.getResourceAsStream(xmlResource);
		XstreamXml xml = (XstreamXml) temp.fromXML(input);
		xml.getAutoProcessClasses().forEach((xstreanClass) -> {
			try {
				xstream.processAnnotations(Class.forName(xstreanClass.getClassName()));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		});
		IOUtils.closeQuietly(input);
	}

	@XStreamAlias("xstream-configuration")
	private static class XstreamXml {
		@XStreamAlias("xstream-annotation-classes")
		List<XStreamClass> autoProcessClasses;

		public List<XStreamClass> getAutoProcessClasses() {
			return autoProcessClasses;
		}

		public void setAutoProcessClasses(List<XStreamClass> autoProcessClasses) {
			this.autoProcessClasses = autoProcessClasses;
		}
	}

	@XStreamAlias("xstream-annotation-class")
	private class XStreamClass {
		@XStreamAlias("class-name")
		@XStreamAsAttribute
		private String className;

		public String getClassName() {
			return className;
		}

		public void setClassName(String className) {
			this.className = className;
		}
	}
}
