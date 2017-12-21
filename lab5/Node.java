package com.mykush;

import java.util.LinkedList;

import com.mykush.conditions.Condition;

public class Node {

	private LinkedList<Condition> forks;
	private String label;
	private int index;
	private boolean leaf;

	public Node() {
		forks = new LinkedList<Condition>();
		leaf = false;
	}

	public void addCondition(Condition condition) {
		forks.add(condition);
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public LinkedList<Condition> getForks() {
		return forks;
	}

	public void setForks(LinkedList<Condition> forks) {
		this.forks = forks;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isLeaf() {
		return leaf;
	}

	@Override
	public String toString() {
		String out = "\n <Node Label = '" + label + "'  isLeaf = '" + isLeaf()
				+ "' index=" + index + " >";
		out += "\n <Conditions>";

		for (Condition condition : forks) {
			out += "\n " + condition.toString();

		}
		out += "\n </Conditions>";
		out += "\n </Node> ";
		return out;
	}

}
