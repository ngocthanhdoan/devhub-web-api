package com.devhub.io.vn.plugins;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.lang3.ObjectUtils;

public class CallMod {
	private Class<?> 			  		CLASS_NEED_CALL;
	private Method                		METHOD_NEED_CALL;
	private Object            	  		INSTANCE;
	private String[] 			  		CALL_MOD_INPUT_STRING = new String[2];
	private Object[] 			  		PARAM_DATA;
	private Class[] 			  		CLASS_TYPE;
	private Exception 			  		NOT_FOUND;
	private Map<?, ?> 			  		TREE_MAP;
	private Map<Integer, Object>  		TREE_MAP_PARAM;
	private ArrayList<?> 		  		TREE_MAP_ARRAY;
	private Method[] 			  		METHODS;
	private Parameter[] 	   	  		PARAMETER;
	private boolean 			  		is_log = true;
	private String 				  		METHOD_NAME;
	private String 				  		MODUN_CLASS_NAME;
	private Class<?> 					METHOD_RETURN;
	private Map<Integer, Object> 		MAP_PARAM_DATA = new TreeMap<Integer, Object>();
	private static Map<Object, Object>  MAP_CODE = new HashMap<Object, Object>();
	static {
		MAP_CODE.put("int", Integer.class);
		MAP_CODE.put("boolean", Boolean.class);
	}
	private returnObject msg = new returnObject();

	public String getMETHOD_NAME() {
		return METHOD_NAME;
	}

	public void setMETHOD_NAME(String mETHOD_NAME) {
		METHOD_NAME = mETHOD_NAME;
	}

	public String getMODUN_CLASS_NAME() {
		return MODUN_CLASS_NAME;
	}

	public void setMODUN_CLASS_NAME(String mODUN_CLASS_NAME) {
		MODUN_CLASS_NAME = mODUN_CLASS_NAME;
	}

	private void offLog() {
		this.is_log = false;
	}

	private void debug(Object mess) {
		if (is_log) {
			System.out.println(mess);
		}
	}

	private void error(Exception e) {
		if (is_log) {
			System.err.println(e.getMessage());
		}
	}

	private Method[] getArrayMethod() {
		this.METHODS = CLASS_NEED_CALL.getMethods();
		return METHODS;
	}

	private Map getMapParam(String MethodName) {
		Map<Integer, String> map = new TreeMap<Integer, String>();
		this.METHODS = CLASS_NEED_CALL.getMethods();
		for (Method method : METHODS) {
			if (MethodName.equals(method.getName())) {
				this.PARAMETER = method.getParameters();
			}
		}
		int i = 0;
		for (Parameter param : PARAMETER) {
			System.out.println(param);
			map.put(i, ObjectUtils.toString(param.getAnnotatedType().getType()).replace("class ", ""));
			i++;
		}

		return map;
	}

	public returnObject settupMethodAndParam() {

		if (getMETHOD_NAME() != null && getMODUN_CLASS_NAME() != null) {
			Method[] getMethod = CLASS_NEED_CALL.getMethods();
			for (Method method : getMethod) {
				if (getMETHOD_NAME().equals(method.getName())) {
					this.PARAMETER = method.getParameters();
					this.METHOD_NEED_CALL = method;
					this.METHOD_RETURN = method.getReturnType();
				}
			}
			int SIZE_PARAM = PARAMETER.length;
			this.CLASS_TYPE = new Class[SIZE_PARAM];
			this.PARAM_DATA = new Object[SIZE_PARAM];
			this.TREE_MAP_PARAM = new TreeMap<Integer, Object>();
			int i = 0;
			for (Parameter param : PARAMETER) {
				this.TREE_MAP_PARAM.put(i,
						ObjectUtils.toString(param.getAnnotatedType().getType()).replace("class ", ""));

			}
			int SIZE_PARAM_DATA = MAP_PARAM_DATA.keySet().size();
			if (SIZE_PARAM > SIZE_PARAM_DATA) {
				msg.setReturnCode(-1);
				msg.setMsgDescs("Thiếu tham số truyền vào");
				return msg;
			} else if (SIZE_PARAM < SIZE_PARAM_DATA) {
				msg.setReturnCode(-1);
				msg.setMsgDescs("Thừa tham số truyền vào");
				return msg;
			}

			if (SIZE_PARAM_DATA > 0) {
				ArrayList PARAMS = new ArrayList(MAP_PARAM_DATA.keySet());
				// System.out.println(LIB.VOTOOL.getJSONString(MAP_PARAM_DATA));
				for (int j = 0; j < PARAMS.size(); j++) {

					try {
						Object data = MAP_PARAM_DATA.get(j);
						if (!ObjectUtils.toString(MAP_CODE.get(TREE_MAP_PARAM.get(j)), "").equals("")) {
							this.CLASS_TYPE[j] = Class
									.forName(MAP_CODE.get(TREE_MAP_PARAM.get(j)).toString().replace("class ", ""));
							this.PARAM_DATA[j] = data;

						} else {
							// System.out.println(TREE_MAP_PARAM.get(j));

							this.CLASS_TYPE[j] = Class.forName(ObjectUtils.toString(TREE_MAP_PARAM.get(j)));
							this.PARAM_DATA[j] = data;
						}

					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						msg.setException(e);
						return msg;
					}
				}

			}
		}
		return msg;

	}

	public void invoke() {

	}

	@SuppressWarnings("unused")
	private void addMap(Map<Integer, Object> map) {
		this.MAP_PARAM_DATA.putAll(map);
	}

	public void addParam(int key, String value) {
		this.MAP_PARAM_DATA.put(key, value);
	}

	public void Test(String text) {
		System.out.println("AHHHHHHHHHHHHHHHH ĐƯỢC RỒI NHÉ" + text + "!!!!");
	}

	public returnObject invoke(String callMod, Map callData) {
		msg = new returnObject();
		if (callMod.contains("/")) {
			this.CALL_MOD_INPUT_STRING = callMod.split("/");
			try {
				this.CLASS_NEED_CALL = Class.forName(CALL_MOD_INPUT_STRING[0]);
				setMODUN_CLASS_NAME(CALL_MOD_INPUT_STRING[0]);
				setMETHOD_NAME(CALL_MOD_INPUT_STRING[1]);
				addMap(callData);
				msg = settupMethodAndParam();
				if (msg.getReturnCode() == 0) {
					this.INSTANCE = CLASS_NEED_CALL.getConstructor().newInstance();
					Object data = METHOD_NEED_CALL.invoke(INSTANCE, PARAM_DATA);
					if (data == null) {
						msg.setReturnData(true);
					} else {
						msg.setReturnData(data);
					}

					return msg;
				} else {
					return msg;
				}

			} catch (Exception e) {
				this.CLASS_NEED_CALL = null;
				this.NOT_FOUND = e;
				error(e);
				msg.setException(e);
			}
		}
		return msg;

	}

	public static void main(String[] args) {
		CallMod call = new CallMod();
		Map MAP_CODE = new HashMap();
		MAP_CODE.put(0, " Thanh ");
		call.invoke("com.devhub.io.vn.plugins.CallMod/Test", MAP_CODE);
	}

}
