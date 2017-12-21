package com.mykush;

import java.util.Map;

public class AttributeInfo {

	String name;

	Map<String, ValueInfo> values;

	Integer rowCount;

	int index;
	
	public Map<String, ValueInfo> getValues() {
		return values;
	}

	public void setValues(Map<String, ValueInfo> values) {
		this.values = values;
	}

	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}
}
