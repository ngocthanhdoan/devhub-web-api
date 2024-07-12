package com.devhub.io.vn.plugins;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * @author Ngoc Thanh Doan
 *
 */
public class returnObject {
	private Exception exception;
	private int returnCode;
	private Object returnData;
	private String msgDescs;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private VoTooL vo$tool;
	private String Method;
    private static final String encode="UTF-8";
	public HttpServletRequest getRequest() {
		return request;
	}

	private Map ipInfo() {
		Map map = new HashMap();
		map.put("XRealIP", request.getHeader("X-Real-IP"));
		map.put("XFORWARDEDFOR", request.getHeader("X-FORWARDED-FOR"));
		return map;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
		try {
			this.request.setCharacterEncoding(encode);
		} catch (UnsupportedEncodingException e) {
			System.err.println("UnsupportedEncodingException: " + e.getMessage());
		}

	}

	public String getMethod() {
		if (request != null) {
			this.Method = request.getMethod();
		}
		return Method;
	}

	public void setMethod(String method) {
		Method = method;
	}

	private static Map<String, String> header;
	static {
		header = new HashMap<String, String>();
		header.put("Access-Control-Allow-Origin", "*");
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setMapHeader(Map map) {
		this.header = map;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
		this.response.setCharacterEncoding(encode);
		this.response.setContentType("application/json; charset=" + encode);
		ArrayList myKeyList = new ArrayList(header.keySet());
		for (int i = 0; i < myKeyList.size(); i++) {
			String key = (String) myKeyList.get(i);
			String value = (String) header.get(myKeyList.get(i));
			this.response.setHeader(key, value);
		}
	}

	public returnObject() {
		this.returnCode = 0;
		this.msgDescs = "";

	}

	public Map returnClientMap() {
		vo$tool = new VoTooL();
		returnObject returnObj = new returnObject();
		if (this.exception != null) {
			returnObj.setException(this.exception);
		}
		returnObj.setMapHeader(header);
		returnObj.setMsgDescs(this.msgDescs);
		returnObj.setReturnCode(this.returnCode);
		returnObj.setReturnData(this.returnData);
		returnObj.setMethod(this.getMethod());
		return vo$tool.objToMap(returnObj);
	}

	public HttpServletResponse returnResp() {
		try {
			this.response.getWriter().append(returnClient());
		} catch (IOException e) {
			System.out.println("hóa hư không!!!");
		}

		return response;
	}

	public String returnClient() {
		vo$tool = new VoTooL();
		returnObject returnObj = new returnObject();
		if (this.exception != null) {
			returnObj.setException(this.exception);
		}
		returnObj.setMapHeader(header);
		returnObj.setMsgDescs(this.msgDescs);
		returnObj.setReturnCode(this.returnCode);
		returnObj.setReturnData(this.returnData);
		returnObj.setMethod(this.getMethod());
		return vo$tool.getJSONString(returnObj);
	}

	private Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
		this.returnCode = -1;
		this.msgDescs = "API ERR DESC ["+exception.getCause().getMessage()+"] ===> PLEASE CHECK";
	
	
	}

	public int getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public Object getReturnData() {
		return returnData;
	}

	public void setReturnData(Object returnData) {
		this.returnData = returnData;
	}

	public String getMsgDescs() {
		return msgDescs;
	}

	public void setMsgDescs(String msgDescs) {
		this.msgDescs = msgDescs;
	}

}
