package com.devhub.io.vn.plugins;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VoTooL {
	private ObjectMapper objectMapper = new ObjectMapper();
	private Exception exception;
	private String string = "{}";

	public Map objToMap(Object obj) {
		Map<String, Object> map = null;
		try {
			map = objectMapper.convertValue(obj, Map.class);
		} catch (Exception e) {
			this.exception = e;
			System.out.println("Votool Convert Failed :" + e.getCause());

		}
		return map;
	}

	public String getJSONString(Map map) {
		try {
			string = objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			this.exception = e;
			System.out.println("Votool Convert Failed :" + e.getCause());
		}
		return string;
	}

	public String getJSONString(Object obj) {
		try {
			string = objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			this.exception = e;
			System.out.println("Votool Convert Failed :" + e.getCause());
		}
		return string;
	}

	public Object mapToObj(Map mapInput, Object objClass) {
		String json = null;
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = null;
		try {
			json = objectMapper.writeValueAsString(mapInput);
			map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
			});
		} catch (JsonMappingException e) {
			this.exception = e;
			System.out.println("Votool Convert Failed :" + e.getCause());
		} catch (JsonProcessingException e) {
			this.exception = e;
			System.out.println("Votool Convert Failed :" + e.getCause());
		}
		return mapper.convertValue(map, objClass.getClass());
	}

	public Map stringJSONToMap(String json) {
		Map map = new HashMap();
		try {
			map = objectMapper.readValue(json, Map.class);
		} catch (JsonMappingException e) {
			this.exception = e;
			System.out.println("Votool Convert Failed :" + e.getCause());

		} catch (JsonProcessingException e) {
			this.exception = e;

			System.out.println("Votool Convert Failed :" + e.getCause());

		}
		return map;
	}

	public Map mapStringToMap(String inputString) {
		Map<String, String> map = new HashMap<>();
		try {
			String cleanedString = inputString.replaceAll("[{}]", "");
			String[] keyValuePairs = cleanedString.split(",");
			for (String pair : keyValuePairs) {
				String[] entry = pair.split("=");
				if (entry.length > 1) {
					String key = entry[0];
					String value = entry[1];
					map.put(key, value);
				} else if (entry.length == 1) {
					map.put(entry[0], "");
				}
			}
		} catch (Exception e) {
			this.exception = e;
			System.out.println("Votool Convert Failed :" + e.getCause());
		}
		return map;

	}

	public Map stringJSONToMapObj(String json) {
		Map map = new HashMap();
		try {
			map = objectMapper.readValue(json, new TypeReference<Map<String, Object>>() {
			});
		} catch (JsonMappingException e) {
			this.exception = e;
			System.out.println("Votool Convert Failed :" + e.getCause());
		} catch (JsonProcessingException e) {
			this.exception = e;
			System.out.println("Votool Convert Failed :" + e.getCause());
		}
		return map;

	}

	public List<Map<String, Object>> stringJSONToListMapObj(String jsonResponse) {
		List<Map<String, Object>> responseList = null;
		try {
			responseList = objectMapper.readValue(jsonResponse, new TypeReference<List<Map<String, Object>>>() {
			});

		} catch (JsonProcessingException e) {
			this.exception = e;
			System.out.println("Votool Convert Failed :" + e.getCause());
		}
		return responseList;
	}

	public boolean isConvertEror() {
		if (exception != null) {
			return true;
		}
		return false;
	}
}
