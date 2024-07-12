package com.devhub.io.vn.plugins;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class API_DB {
	private String URI_API;
	private String CALL_MOD;
	private String tableName  = "devhub_api_config";
	private String METHOD 	  = "ALL";
	private String NEED_CHECK = "N";
	private String NEED_LOG   = "N";
	private int    COUNT_ITEM 	  = 1;
	private VoTooL votool;
	private Map<Integer, String> 	  MAP_PARAM;
	private List<String> 			  CHECK_DUP;
	private List<Map<String, Object>> LIST_API_DB;
	private DataSet ds;

	public API_DB(DataSet ds) throws Exception{
		votool 		= new VoTooL();
		MAP_PARAM 	= new TreeMap<Integer, String>();
		CHECK_DUP 	= new ArrayList<String>();
		LIST_API_DB = new ArrayList<Map<String, Object>>();
		this.ds = ds;
	}

	public API_DB() {
		votool 		= new VoTooL();
		MAP_PARAM 	= new TreeMap<Integer, String>();
		CHECK_DUP 	= new ArrayList<String>();
		LIST_API_DB = new ArrayList<Map<String, Object>>();
	}

	public void addParam(String value) {
		boolean is_next = true;
		if (CHECK_DUP.size() > 0) {
			for (String string : CHECK_DUP) {
				if (value.toUpperCase().equals(string.toUpperCase())) {
					is_next = false;
				}
			}
			if (is_next) {
				this.MAP_PARAM.put(COUNT_ITEM, value);
				this.COUNT_ITEM++;
				this.CHECK_DUP.add(value);
			}
		} else {
			this.MAP_PARAM.put(COUNT_ITEM, value);
			this.COUNT_ITEM++;
			this.CHECK_DUP.add(value);

		}

	}

	private String getMAP_PARAM() {
		return votool.getJSONString(MAP_PARAM);
	}

	public String getURI_API() throws Exception {
		if (URI_API == null || URI_API.isEmpty()) {
			throw new Exception("URI_API is empty");
		}
		return URI_API;
	}

	public void setURI_API(String uRI_API) {
		this.URI_API = uRI_API;
		ds.setField("URI_API", URI_API);
		this.LIST_API_DB = ds.searchAndRetrieve("SELECT * FROM " + tableName + " WHERE URI_API=:URI_API");
	}

	public String getMETHOD() {
		return METHOD;
	}

	public void setMETHOD(String mETHOD) {
		METHOD = mETHOD;
	}

	public String getCALL_MOD() {

		return CALL_MOD;
	}

	public void setCALL_MOD(String cALL_MOD) {
		CALL_MOD = cALL_MOD;
	}

	public String getPARAM() {
		return getMAP_PARAM();
	}

	public String getNEED_CHECK() {
		return NEED_CHECK;
	}

	public void setNEED_CHECK(String nEED_CHECK) {
		NEED_CHECK = nEED_CHECK;
	}

	public String getNEED_LOG() {
		return NEED_LOG;
	}

	public void setNEED_LOG(String nEED_LOG) {
		NEED_LOG = nEED_LOG;
	}

	public void setAPI(API_DB api) throws Exception {
		ds.clear();
		LIST_API_DB= new ArrayList<Map<String,Object>>();
		ds.setField("URI_API", URI_API);
		this.LIST_API_DB = ds.searchAndRetrieve("SELECT * FROM " + tableName + " WHERE URI_API=:URI_API");
		if(LIST_API_DB!=null) {
			if(LIST_API_DB.size()>0) {
				System.err.println("NOTIFY: the url "+URI_API+" have found: {"+LIST_API_DB.size()+" data.}");
		    }else {
				String sql = "INSERT INTO " + tableName + "(URI_API, METHOD, CALL_MOD, PARAM, NEED_CHECK, NEED_LOG)"
						+ "VALUES(:URI_API, :METHOD, :CALL_MOD, :PARAM, :NEED_CHECK, :NEED_LOG);";
				
				Map mapAPI_DB = votool.objToMap(api);
				ArrayList myKeyList = new ArrayList(mapAPI_DB.keySet());
				for (int i = 0; i < myKeyList.size(); i++) {
					String key = (String) myKeyList.get(i);
					String value = (String) mapAPI_DB.get(myKeyList.get(i));
					ds.setField(key.toUpperCase(), value);
				}
				ds.update(sql);	
			}
		}
	}

	public API_DB getAPI(String METHOD) {
		API_DB newApi = null;
		//ds.clear();
		if(LIST_API_DB!=null) {
			if (LIST_API_DB.size() > 0) {
				for (Map map : LIST_API_DB) {
					if (METHOD.toUpperCase().equals(map.get("method").toString().toUpperCase())
							|| "ALL".equals(map.get("method").toString().toUpperCase())) {
						newApi = new API_DB();
						newApi.setCALL_MOD(map.get("call_mod").toString());
						newApi.setMETHOD(map.get("method").toString());
						newApi.setNEED_CHECK(map.get("need_check").toString());
						newApi.setNEED_LOG(map.get("need_log").toString());
					}
				}
			}	
		}
		
		return newApi;
	}

	public Map API_PARAM() {
		String sql = "SELECT PARAM FROM " + tableName + " WHERE URI_API=:URI_API";
		try {
			ds.clear();
			ds.setField("URI_API", getURI_API());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Map<String, Object>> li=null;
		Map<Integer, String> MAP_PARAM_DB = new HashMap<Integer, String>();
		if(LIST_API_DB!=null) {
			if (LIST_API_DB.size() > 0) {
				li = LIST_API_DB;
				System.out.println("api in cache!!!!");
			} else {
				System.out.println("query api form database!!!");
				ds.clear();
				try {
					li = ds.searchAndRetrieve(sql);
				} catch (Exception e) {
					System.err.println("no such api!");
				}
			}
			if(li!=null) {
				for (Map<String, Object> map : li) {
					MAP_PARAM_DB = (Map<Integer, String>) votool.stringJSONToMap((String) map.get("param"));
				}	
			}else {
				MAP_PARAM_DB=MAP_PARAM;
			}
			
		}
			
		return MAP_PARAM_DB;
	}
	public void invoke(Map mapParams) {
		CallMod call= new CallMod();
		//call.addParam(COUNT_ITEM, CALL_MOD);
		//call.addParam(COUNT_ITEM, CALL_MOD);
		//call.addParam(COUNT_ITEM, CALL_MOD);
		//call.addParam(COUNT_ITEM, CALL_MOD);
		System.out.println(CALL_MOD);
	}

	public static void main(String[] args) {
		DataSet ds = new DataSet();
		ds.setHOSTNAME("127.0.0.1");
		ds.setDB_DATABASE_NAME("devhub_web_app");
		ds.setDB_USERNAME("root");
		ds.setDB_PASSWORD("khongbiet");
		API_DB api=null;
		try {
			api = new API_DB(ds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		api.addParam("Test");
		api.setURI_API("/api/v1/user");
		api.setCALL_MOD("com.dano.api.index.mod.index_mod");
		//api.invoke();		
		try {
			api.setAPI(api);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("...");
		System.out.println(new VoTooL().getJSONString(api));
	}
}
