package com.mykush.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Itemset extends HashSet<Integer> {

	public Itemset(Itemset is1) {
		super(is1);
	}

	public Itemset() {
		super();
	}

	public int getSupport() {
		return SupportMap.get(this);
	}


	public int getRelativeSupport() {
		return SupportMap.getRelative(this);
	}

	public List<Itemset> subsetWithoutOneElement() {
		List<Itemset> list = new ArrayList<>();
		List<Integer> itemsetAsArray = new ArrayList<>(this);
		int size = itemsetAsArray.size();
		int limit = (int) Math.pow(2, size) - 1;
		for (int i = 0; i < limit; ++i) {
			Itemset subset = new Itemset();
			for (int j = 0; j < size; ++j) {
				if (((i >> j) & 1) == 1) {
					subset.add(itemsetAsArray.get(j));
				}
			}
			if (!subset.isEmpty() && subset.size() == size - 1) {
				list.add(subset);
			}
		}
		return list;
	}

	public List<Rule> generateRules() {
		List<Rule> rules = new ArrayList<>();
		List<Integer> list = new ArrayList<>(this);
		int size = this.size();
		for (int i = 1, limit = (int) Math.pow(2, size) - 1; i < limit; ++i) {
			Itemset premisse = new Itemset();
			Itemset conclusion = new Itemset();
			for (int j = 0; j < size; ++j) {
				if (((i >> j) & 1) == 1) {
					premisse.add(list.get(j));
				} else {
					conclusion.add(list.get(j));
				}
			}
			rules.add(new Rule(premisse, conclusion));
		}
		return rules;
	}

	@Override
	public String toString() {
		String result = "";
		int count = 0;
		for (Integer i : this) {
			if (count++ != 0) {
				result = result.concat(", ");
			}
			result = result.concat(LabelsMap.getInstance()
					.nameCorrespondence(i));
		}
		return result;
	}
}
