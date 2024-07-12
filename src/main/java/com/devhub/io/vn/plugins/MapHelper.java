package com.devhub.io.vn.plugins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.ObjectUtils;

public class MapHelper {
	private String key;
	private String value;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void put(String key, String value) {
		this.key=key;
		this.value=value;
	}
	
	public static List<MapHelper> mapToListMap(Map<String, String> map) {
		List<MapHelper> listReturn = new ArrayList<MapHelper>();
		for (Entry<String, String> entry : map.entrySet()) {
			// query.addParameter(entry.getKey(), entry.getValue());
			//Map<String, String> mapoutput = new HashMap<String, String>();
			MapHelper mapoutput = new MapHelper();
			mapoutput.put(ObjectUtils.toString(entry.getKey()),  ObjectUtils.toString(entry.getValue()));
		
			listReturn.add(mapoutput);
		}
		return listReturn;
	}
	public static void main(String[] args) {
		Map mapTest= new HashMap();
		mapTest.put("a","a Nef");
		mapTest.put("b","b Nef");
		mapTest.put("c","c Nef");
		mapTest.put("d","d Nef");
		MapHelper vo= (MapHelper) mapToListMap(mapTest).get(0);
		System.out.println(vo.getKey());
		
	}
}
