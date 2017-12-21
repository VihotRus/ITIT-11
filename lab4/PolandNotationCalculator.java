package com.company;

import java.util.*;

/**
 * Created by Andrii on 28.10.2017.
 */
public class PolandNotationCalculator {

	public static double calculateSimplePolandNotation(String input) throws Exception {
		double dA = 0;
		double dB = 0;
		String temp;
		Deque<Double> stack = new ArrayDeque<Double>();
		Stack<String> st = new Stack<>();
		for (String s : input.trim().split(" ")) {
			st.push(s);
		}

		while (!st.isEmpty()) {
			temp = st.pop().trim();
			if (temp.length() == 1 && Utils.isOperator(temp.charAt(0))) {
				if (stack.size() < 2) {
					throw new Exception("Wrong data amount in stack for operation" + temp);
				}
				dA = stack.pop();
				dB = stack.pop();
				dA = calculate(temp.charAt(0), dA, dB);
				stack.push(dA);
			} else {
				dA = Double.parseDouble(temp);
				stack.push(dA);
			}
		}
		return stack.pop();
	}

	public static double calculateReversePolandNotation(String input) throws Exception {
		double dA = 0;
		double dB = 0;
		String temp;
		Deque<Double> stack = new ArrayDeque<Double>();
		StringTokenizer st = new StringTokenizer(input);

		while(st.hasMoreTokens()) {
			try {
				temp = st.nextToken().trim();
				if (1 == temp.length() && Utils.isOperator(temp.charAt(0))) {
					if (stack.size() < 2) {
						throw new Exception("Wrong data amount in stack for operation" + temp);
					}
					dB = stack.pop();
					dA = stack.pop();
					dA = calculate(temp.charAt(0), dA, dB);
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

	private static double calculate(char operator, double dA, double dB) throws Exception {
		switch (operator) {
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
				throw new Exception("Unacceptable  operation" + String.valueOf(operator));
		};
		return dA;
	}
}
