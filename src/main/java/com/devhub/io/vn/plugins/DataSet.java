package com.devhub.io.vn.plugins;

import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class DataSet {
	private String HOSTNAME;
	private String DB_URL;
	private String DB_USERNAME;
	private String DB_PASSWORD;
	private String DB_DATABASE_NAME;
	private boolean SSL = false;
	private Sql2o sql2o;
	private Map<String, Object> parameters;
	static {
		System.out.println("====================================");
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("SETUP Driver is OK!");
		} catch (Exception e) {
			System.out.println("SETUP Driver is FAILED!");
			System.err.println("ERROR: " + e.getMessage());
		}
		System.out.println("====================================");
	}

	public DataSet() {
		parameters = new HashMap<String, Object>();
	}

	public void CONNECT_SSL() {
		this.SSL = true;
	}

	private String getHOSTNAME() {
		return HOSTNAME;
	}

	public void setHOSTNAME(String hOSTNAME) {
		HOSTNAME = hOSTNAME;
	}

	public String getDB_URL() {
		this.DB_URL = "jdbc:mysql://" + HOSTNAME + ":3306/" + DB_DATABASE_NAME
				+ "?useSSL=false&useUnicode=yes&characterEncoding=UTF-8&allowPublicKeyRetrieval=true";
		if (SSL) {
			this.DB_URL = "jdbc:mysql://" + HOSTNAME + ":3306/" + DB_DATABASE_NAME
					+ "?useUnicode=yes&characterEncoding=UTF-8";
		}
		System.out.println(DB_URL);
		return DB_URL;
	}

	public void setField(String key, Object value) {
		parameters.put(key, value);
	}

	public void clear() {
		parameters.clear();
	}

	private String getDB_USERNAME() {
		return DB_USERNAME;
	}

	public void setDB_USERNAME(String dB_USERNAME) {
		DB_USERNAME = dB_USERNAME;
	}

	private String getDB_PASSWORD() {
		return DB_PASSWORD;
	}

	public void setDB_PASSWORD(String dB_PASSWORD) {
		DB_PASSWORD = dB_PASSWORD;
	}

	private String getDB_DATABASE_NAME() {
		return DB_DATABASE_NAME;
	}

	public void setDB_DATABASE_NAME(String dB_DATABASE_NAME) {
		DB_DATABASE_NAME = dB_DATABASE_NAME;
	}

	public synchronized Sql2o getSql2o() {
		if (sql2o == null) {
			try {
				sql2o = new Sql2o(getDB_URL(), getDB_USERNAME(), getDB_PASSWORD());
			} catch (Exception e) {
				System.err.println(DataSet.class.getPackageName() + "["
						+ Thread.currentThread().getStackTrace()[1].getLineNumber() + "]: " + e.getMessage());
			}
		}

		return sql2o;
	}

	@SuppressWarnings("resource")
	public int update(String sql) {
		Connection connection;
		try {
			connection = getSql2o().open();

			Query query = null;

			try {
				String sql2 = CodeMap.getSQLString(sql);
				;

				if (!sql2.equals("")) {
					sql = sql2;
				}
				query = connection.createQuery(sql);
				query.getConnection().getJdbcConnection().setAutoCommit(false);
				query = setParameter(query);

				connection = query.executeUpdate(); // Xác nhận thay đổi
				connection.commit();
				System.out.println(query.toString());
				System.out.println("insertComplete");
				return connection.getResult();
			} catch (Exception e) {
				connection.rollback(); // Rollback nếu có lỗi
				e.printStackTrace();
				return 0;
			} finally {
				if (query != null) {
					query.close();
				}
				if (connection != null) {
					connection.close();
				}
			}

		} catch (Sql2oException e) {
			LogFailed(e);
			return 0;
		}
	}

	public List<Map<String, Object>> searchAndRetrieve(String sql) {
		System.out.println(sql);
		try (Connection connection = getSql2o().open()) {
			List<Map<String, Object>> list = null;
			Query query = null;
			String sql2 = CodeMap.getSQLString(sql);
			;
			if (!sql2.equals("")) {
				sql = sql2;
			}
			try {
				query = connection.createQuery(sql);
				query = setParameter(query);
				list = query.executeAndFetchTable().asList();
			} catch (Exception e) {
				System.err.println(DataSet.class.getPackageName() + "["
						+ Thread.currentThread().getStackTrace()[1].getLineNumber() + "]: " + e.getMessage());
				//connection.rollback();
			} finally {
				if (query != null) {
					query.close();
				}
				if(connection!=null) {
					connection.close();	
				}
				
			}

			return list;
		} catch (Sql2oException e) {
			LogFailed(e);
			return null;
		}
	}

	public Query setParameter(Query query) {

		for (Map.Entry<String, Object> entry : parameters.entrySet()) {
			query.addParameter(entry.getKey(), entry.getValue());
		}
		return query;
	}

	public void LogFailed(Exception e) {
		System.err.println("==========================DATABASE CONNECT CRASH===========================");
		System.err.println("Failed to open database connection: " + e.getMessage());
		System.err.println("===========================================================================");
	}

	public static void main(String[] args) {
		DataSet ds = new DataSet();
		ds.setHOSTNAME("103.27.236.132");
		ds.setDB_DATABASE_NAME("devhub_web_app");
		ds.setDB_USERNAME("cxluser");
		ds.setDB_PASSWORD("Thanh0974135042!");
		System.out.println(ds.searchAndRetrieve("select * from devhub_code_map"));
	}
}
