package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrii on 28.10.2017.
 */
public class Utils {

	private static final Map<Character, Integer> sOperators = new HashMap<>();
	static {
		sOperators.put('^', 3);
		sOperators.put('*', 2);
		sOperators.put('/', 2);
		sOperators.put('%', 2);
		sOperators.put('+', 1);
		sOperators.put('-', 1);
	}

	public static boolean isOperator(char c) {
		return sOperators.containsKey(c);
	}

	public static int getOperatorPriority(char operator) {
		return sOperators.getOrDefault(operator, -1);
	}

}
