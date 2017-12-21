package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Andrii on 25.10.2017.
 */
public class Calculator {

	private static final Map<Character, Integer> sOperators = new HashMap<>();
	static {
		sOperators.put('^', 3);
		sOperators.put('*', 2);
		sOperators.put('/', 2);
		sOperators.put('%', 2);
		sOperators.put('+', 1);
		sOperators.put('-', 1);
	}

	public static void main(String[] args) throws Exception {
	BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
	String sIn;

	try {
		System.out.println("Input expression for calculation. Supported digits, operations +,-,*,/,^,% and priority in the form of brackets ( and ):");
		sIn = d.readLine();
		d.close();
		sIn = toReversePolandNotation(sIn);
		System.out.println(String.format("Reverse poland notation: %s", sIn));
		System.out.println(String.format("Result: %s", String.valueOf(calculate(sIn))));
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
}

	private static String toReversePolandNotation(String input) throws Exception {
		StringBuilder operationStack = new StringBuilder();
		StringBuilder output = new StringBuilder();
		char inputSymbol;
		char tempSymbol;

		for (int i = 0; i < input.length(); i++) {
			inputSymbol = input.charAt(i);
			if (isOperator(inputSymbol)) {
				while (operationStack.length() > 0) {
					tempSymbol = operationStack.charAt(operationStack.length() - 1);
					if (isOperator(tempSymbol) && (getOperatorPriority(inputSymbol) <= getOperatorPriority(tempSymbol))) {
						output.append(" ").append(tempSymbol).append(" ");
						operationStack.setLength(operationStack.length() - 1);
					} else {
						output.append(" ");
						break;
					}
				}
				output.append(" ");
				operationStack.append(inputSymbol);
			} else if ('(' == inputSymbol) {
				operationStack.append(inputSymbol);
			} else if (')' == inputSymbol) {
				tempSymbol = operationStack.charAt(operationStack.length() - 1);
				while ('(' != tempSymbol) {
					if (operationStack.length() < 1) {
						throw new Exception("Wrong expression. Check it again!");
					}
					output.append(" ").append(tempSymbol);
					operationStack.setLength(operationStack.length() - 1);
					tempSymbol = operationStack.charAt(operationStack.length() - 1);
				}
				operationStack.setLength(operationStack.length() - 1);
			} else {
				output.append(inputSymbol);
			}
		}
		while (operationStack.length() > 0) {
			output.append(" ").append(operationStack.charAt(operationStack.length() - 1));
			operationStack.setLength(operationStack.length() - 1);
		}
		return  output.toString();
	}

	private static boolean isOperator(char c) {
		return sOperators.containsKey(c);
	}


	private static int getOperatorPriority(char operator) {
		return sOperators.getOrDefault(operator, -1);
	}


	private static double calculate(String input) throws Exception {
		double dA = 0;
		double dB = 0;
		String temp;
		Deque<Double> stack = new ArrayDeque<Double>();
		StringTokenizer st = new StringTokenizer(input);

		while(st.hasMoreTokens()) {
			try {
				temp = st.nextToken().trim();
				if (1 == temp.length() && isOperator(temp.charAt(0))) {
					if (stack.size() < 2) {
						throw new Exception("Wrong data amount in stack for operation" + temp);
					}
					dB = stack.pop();
					dA = stack.pop();
					switch (temp.charAt(0)) {
						case '+':
							dA += dB;
							break;
						case '-':
							dA -= dB;
							break;
						case '/':
							dA /= dB;
							break;
						case '*':
							dA *= dB;
							break;
						case '%':
							dA %= dB;
							break;
						case '^':
							dA = Math.pow(dA, dB);
							break;
						default:
							throw new Exception("Unacceptable  operation" + temp);
					}
					stack.push(dA);
				} else {
					dA = Double.parseDouble(temp);
					stack.push(dA);
				}
			} catch (Exception e) {
				throw new Exception("Unacceptable symbol in operation");
			}
		}

		if (stack.size() > 1) {
			throw new Exception("Operators number and operands number are different");
		}
		return stack.pop();
	}
}
