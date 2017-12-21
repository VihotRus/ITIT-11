package com.company;

import java.util.ArrayDeque;

/**
 * Created by Andrii on 28.10.2017.
 */
public class PolandNotationGenerator {

	public static String toReversePolandNotation(String input) throws Exception {
		ArrayDeque<Character> operationStack = new ArrayDeque<>();
		StringBuilder output = new StringBuilder();
		char inputSymbol;
		char tempSymbol;

		for (int i = 0; i < input.length(); i++) {
			inputSymbol = input.charAt(i);
			if (Utils.isOperator(inputSymbol)) {
				while (!operationStack.isEmpty()) {
					tempSymbol = operationStack.peekLast();
					if (Utils.isOperator(tempSymbol) && (Utils.getOperatorPriority(inputSymbol) <= Utils.getOperatorPriority(tempSymbol))) {
						output.append(" ").append(tempSymbol).append(" ");
						operationStack.removeLast();
					} else {
						output.append(" ");
						break;
					}
				}
				output.append(" ");
				operationStack.offer(inputSymbol);
			} else if ('(' == inputSymbol) {
				operationStack.offerLast(inputSymbol);
			} else if (')' == inputSymbol) {
				tempSymbol = operationStack.peekLast();
				while ('(' != tempSymbol) {
					if (operationStack.isEmpty()) {
						throw new Exception("Wrong expression. Check it again!");
					}
					output.append(" ").append(tempSymbol);
					operationStack.removeLast();
					tempSymbol = operationStack.peekLast();
				}
				operationStack.removeLast();
			} else {
				output.append(inputSymbol);
			}
		}
		while (!operationStack.isEmpty()) {
			output.append(" ").append(operationStack.pollLast());
		}
		return  output.toString();
	}

}
