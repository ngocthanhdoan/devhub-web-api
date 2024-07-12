package com.devhub.io.vn.plugins;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;

public class CodeMap {
	private static List<Map<String, Object>> codeMaps;
	private static String searchCodeMap = "SELECT * FROM " + "devhub_code_map";
	private static boolean cache = false;

	public static void reNewData(DataSet ds) {
		if (codeMaps == null) {
			codeMaps = ds.searchAndRetrieve(searchCodeMap);
		}
	}

	public void clearCacheCodeMap(DataSet ds) {
		codeMaps.clear();
		if (cache) {
			reNewData(ds);
			cache = false;
		} else {
			cache = true;
			clearCacheCodeMap(ds);
		}
	}

	public static String getSQLString(String keySql) {
		if (codeMaps != null) {
			for (Map<String, Object> map : codeMaps) {
				if (map != null) {
					
					if (keySql.equals(ObjectUtils.toString(map.get("code_name")))) {
						return ObjectUtils.toString(map.get("sqlstring"));
					}
				}
			}
			if (!keySql.equals(searchCodeMap)) {
				System.err.println("[WARNING] sql key not found in database: " + keySql);
			}
		}

		return "";
	}

	public static void main(String[] args) {
		// System.out.println(new VoTooL().getJSONString(codeMaps));
		System.out.println(searchCodeMap);
	}

}
