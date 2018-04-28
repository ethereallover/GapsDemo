package com.hundsun.gaps.flowcomponents;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.Resource;

import com.hundsun.gaps.flowexecutor.function.interfaces.IResourceScanAware;

public class PngComponent implements IResourceScanAware {

	Map<String, Resource> map;

	public PngComponent() {
		map = new HashMap<String, Resource>();
	}

	@Override
	public String getSuffix() {
		return ".png";
	}

	@Override
	public void setResources(Resource[] resources) {
		for (Resource resource : resources) {
			map.put(resource.getFilename(), resource);
		}
	}

	public Resource getPngResource(String fileName) {
		return map.get(fileName);
	}

}
