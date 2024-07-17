package com.devhub.io.vn.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devhub.io.vn.plugins.DataSet;

@Component
public class ApiModun {
	private final DataSet dataSet;

	@Autowired
	public ApiModun(DataSet dataSet) {
		this.dataSet = dataSet;
	}

	public List<Map<String, Object>> selectApi(String api_url) {
		dataSet.clear();
		dataSet.setField("api_url", api_url);
		return dataSet.searchAndRetrieve("SELECT * FROM reflected_classes where reflected_url= :api_url");
	}
	public String getApiMethod(String api_url) {
		dataSet.clear();
		dataSet.setField("api_url", api_url);
		List<Map<String, Object>> li = dataSet
				.searchAndRetrieve("SELECT * FROM reflected_classes where reflected_url= :api_url");
		String ClassMethod = "";
		try {
			for (Map<String, Object> map : li) {
				return map.get("class_name") + "/" + map.get("method_name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ClassMethod;
	}
	
}
