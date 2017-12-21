package com.mykush.sources;

import com.mykush.core.Itemset;
import com.mykush.core.LabelsMap;

import java.util.ArrayList;
import java.util.List;

public abstract class CsvSource implements TransactionSource {

	protected List<Integer> allProducts = new ArrayList<>();

	protected List<Itemset> fromCsvStrings(List<String> sources) {
		List<Itemset> transactions = new ArrayList<>();
		for (String s : sources) {
			Itemset tset = new Itemset();
			for (String q : s.split(",")) {
				int correspondance = LabelsMap.getInstance()
						.addNameCorrespondance(q);
				tset.add(correspondance);
			}
			transactions.add(tset);
		}
		return transactions;
	}
}
