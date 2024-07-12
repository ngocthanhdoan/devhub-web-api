package com.devhub.io.vn.api;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.devhub.io.vn.plugins.API_DB;
import com.devhub.io.vn.plugins.DataSet;
import com.devhub.io.vn.plugins.returnObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ApiController {
	private final DataSet ds;
	private returnObject msg;
	private Map treeMap = new TreeMap();
	private List<Map> treeMapList;

	public ApiController(DataSet ds) {
		super();
		this.ds = ds;
	}

	@RequestMapping(value = "/api/**", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public HttpServletResponse service(HttpServletRequest request, HttpServletResponse response,
			@RequestParam Map<String, Object> params) throws ServletException, IOException {
		msg = new returnObject();
		msg.setRequest(request);
		msg.setResponse(response);
		String url = request.getRequestURI();
		int indexUrl = url.indexOf("/api/");
		API_DB api = null;
		try {
			api = new API_DB(ds);
		} catch (Exception e) {
			msg.setReturnCode(-1);
			msg.setMsgDescs("Lỗi truy cập api: " + e.getMessage());
			return msg.returnResp();
		}
		api.setURI_API(request.getRequestURI().substring(indexUrl + 5));// 去掉/api/
		try {
			treeMap = api.API_PARAM();
		} catch (Exception e) {
			msg.setReturnCode(-1);
			msg.setMsgDescs("Lỗi truy cập api: " + e.getMessage());
			return msg.returnResp();
		}
		if (treeMap != null) {
			API_DB newApi = api.getAPI(request.getMethod());
			treeMapList = new ArrayList(treeMap.keySet());

			if (newApi != null) {
				if (!newApi.getMETHOD().toUpperCase().equals("ALL")) {
					if (!request.getMethod().toUpperCase().equals(newApi.getMETHOD().toUpperCase())) {
						msg.setMsgDescs("Method " + request.getMethod() + " không được sử dụng");
						msg.setReturnCode(-1);
						return msg.returnResp();
					}
				}
				String[] CALL_MOD_info = newApi.getCALL_MOD().split("/");
				Class[] Class_type = new Class[treeMapList.size()];
				Object[] PARAM_DATA = new Object[treeMapList.size()];
				for (int i = 0; i < treeMapList.size(); i++) {
					System.out.println(treeMap.get(treeMapList.get(i)));
					String param = request.getParameter(ObjectUtils.toString(treeMap.get(treeMapList.get(i))));
					PARAM_DATA[i] = param;
					Class_type[i] = String.class;

				}

				try {
					Class<?> clazz = Class.forName(CALL_MOD_info[0]);
					Method method = clazz.getMethod(CALL_MOD_info[1], Class_type);
					Object instance = clazz.getConstructor().newInstance();
					List<Map<String, Object>> result = (List<Map<String, Object>>) method.invoke(instance, PARAM_DATA);
					msg.setReturnData(result);
					msg.setMsgDescs("Complete!");
					return msg.returnResp();
				} catch (Exception e) {
					msg.setException(e);
					return msg.returnResp();
				}
			}
		} else {
			msg.setReturnCode(-1);
			msg.setMsgDescs("API chưa được triển khai");
			return msg.returnResp();
		}
		return msg.returnResp();

	}

	@RequestMapping(value = "/Test")
	@ResponseBody
	public String getIndex1() {
		try {
			System.out.println(ds.searchAndRetrieve("select * from devhub_code_map"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "helloworld";
	}
}
