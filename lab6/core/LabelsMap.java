package com.mykush.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabelsMap {

	private Map<String, Integer> nameInt;
	private Map<Integer, String> intName;
	private int lastAvailableProductId = 0;

	private LabelsMap() {
		nameInt = new HashMap<>();
		intName = new HashMap<>();
	}

	static private LabelsMap instance;

	static public LabelsMap getInstance() {
		if (instance == null) {
			instance = new LabelsMap();
		}
		return instance;
	}

	public String nameCorrespondence(Integer i) {
		return ( intName.containsKey(i) ) ? intName.get(i) : null;
	}

	public int addNameCorrespondance(String s) {
		if (nameInt.containsKey(s)) {
			return nameInt.get(s);
		}

		int res = lastAvailableProductId;
		nameInt.put(s, lastAvailableProductId);
		intName.put(lastAvailableProductId, s);
		++lastAvailableProductId;
		return res;
	}

	public List<Integer> getAllProducts() {
		List<Integer> list = new ArrayList<>();
		for (String s : nameInt.keySet()) {
			list.add(nameInt.get(s));
		}
		return list;
	}

	public void clear() {
		nameInt.clear();
		intName.clear();
		lastAvailableProductId = 0;
	}
}
