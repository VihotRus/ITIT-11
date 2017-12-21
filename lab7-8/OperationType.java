package com.mykush;

import org.omg.CORBA.UNKNOWN;

import javax.swing.plaf.TextUI;

/**
 * Created by Andrii on 11.11.2017.
 */
public enum  OperationType {
	Unknown("", -1),
	Not("\u00AC", 3),
	And("\u2227", 1),
	Or("\u2228", 1),
	Imp("\u2192", 0),
	Equals("~", 2),
	LBracket("(", -1),
	RBracket(")", -1);

	private int priority;
	private String value;

	public static boolean isOperator(String symbol) {
		for (OperationType type : OperationType.values()) {
			if (type.toString().equals(symbol)) {
				return true;
			}
		}
		return false;
	}

	public static OperationType parse(String symbol) {
		for (OperationType type : OperationType.values()) {
			if (type.toString().equals(symbol)) {
				return type;
			}
		}
		return Unknown;
	}

	OperationType(String value, int priority) {
		this.value = value;
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public String toString() {
		return value;
	}
}
