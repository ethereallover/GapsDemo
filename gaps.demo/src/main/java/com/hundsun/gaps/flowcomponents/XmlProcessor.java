package com.hundsun.gaps.flowcomponents;

import java.util.Map;

import org.json.JSONObject;
import org.json.XML;
import java.lang.String;

public class XmlProcessor {
	public static Map<String, Object> xmlToMap(String xmlString) {
		JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
		return xmlJSONObj.toMap();
	}

	public static String mapToXml(Map<String, Object> map, String encode) {
		JSONObject json = new JSONObject(map);
		return "<?xml version=\"1.0\" encoding=" + encode + "?>\n" + XML.toString(json);
	}
}
