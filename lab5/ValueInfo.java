package com.mykush;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ValueInfo {

	Map<String,Integer> attributeClasses;
	BitSet rows;
	int rowsCount;
	double entropy;
	
	public ValueInfo(Set<String> classes,BitSet rows) {
		this.attributeClasses = new HashMap<String, Integer>();
		for (String currentClass : classes) {
			attributeClasses.put(currentClass,0 );
		}
		this.rows = rows;
		this.rowsCount = 0;
		this.entropy = 0;
	}

	public void increaseClass(String className){
		attributeClasses.put(className, attributeClasses.get(className)+1);
		
	}

	public void increaseRowCount(){
		rowsCount++;
	}

	public void setRowAt(int index){
		rows.set(index);
	}
	
	public Map<String, Integer> getAttributeClasses() {
		return attributeClasses;
	}

	public BitSet getRows() {
		return rows;
	}

	public int getRowsCount() {
		return rowsCount;
	}

	public void setEntropy(double entropy) {
		this.entropy = entropy;
	}
	
	public double getEntropy() {
		return entropy;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("\n--- Classes ---");
		sb.append("\n");
		attributeClasses.forEach((k,v)-> sb.append(k+" (count) = "+v+" |"));
		sb.append("\n");
		sb.append(" --- Rows ---");
		sb.append(rows);
		sb.append("\n");
		sb.append("--- Count ----");
		sb.append(rowsCount);
		return sb.toString();
	}
	
}
