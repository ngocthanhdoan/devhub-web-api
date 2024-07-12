package com.j4fun.eNum;

public class BatQuai {
	public static final int[] YAO_INT = { 0, 1 };
	public static final String[] YAO_STRING = { "YIN", "YANG" };
	private String id;
	private String name; // Defauld Vn
	private String symbol; // Tung Cua
	private String description;
	private String name_china;
    private String getYaoString(int yao_int) {
    	return YAO_STRING[yao_int];
    }
    private int getYaoInt(String yao_str) {
    	for (int i = 0; i < YAO_STRING.length; i++) {
		if(YAO_STRING[i].equals(yao_str.toUpperCase()))	{
			
		}
		}
    	return 0;
    }
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName_china() {
		return name_china;
	}

	public void setName_china(String name_china) {
		this.name_china = name_china;
	}

}
