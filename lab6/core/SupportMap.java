package com.mykush.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupportMap {
	private static Map<Itemset, Integer> map = new HashMap<>();
	
	private static List<Itemset> transactions = null;

	public static void setup(List<Itemset> _transactions) {
		clear();
		transactions = _transactions;
	}

	public static int get(Itemset itemset) {
		if (!map.containsKey(itemset)) {
			int support = 0;
			for (Itemset it : transactions) {
				if (it.containsAll(itemset)) {
					++support;
				}
			}
			map.put(itemset, support);
			return support;
		}
		return map.get(itemset);
	}

	public static int getRelative(Itemset itemset) {
		return 100 * get(itemset) / transactions.size();
	}

	public static boolean alreadyProcessed(Itemset itemset) {
		return map.containsKey(itemset);
	}

	public static void clear() {
		map.clear();
	}
}
