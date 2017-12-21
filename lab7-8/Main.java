package com.mykush;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
    System.out.println("!----------------------------------------------------------!");
    System.out.println("Task 2");
	Expression expression = new Expression("( p \u2192 q ) \u2228 ( \u00AC p \u2192 q )");
	System.out.println(expression.toString());
	expression.printPostfixNotation();
	expression.printTruthTable();
	System.out.println("Tautology: " + String.valueOf(expression.isTautology()));
	System.out.println("!----------------------------------------------------------!");

	System.out.println("!----------------------------------------------------------!");
	System.out.println("Task 3");
	expression = new Expression("p \u2192 q");
	System.out.println(expression.toString());
	expression.printTruthTable();

	expression = new Expression("\u00AC p \u2228 q");
	System.out.println(expression.toString());
	expression.printTruthTable();


//	Expression expression = new Expression("( ( p \u2192 q ) \u2227 ( q \u2192 r ) ) ~ ( p \u2192 r )");
//	System.out.println(expression.toString());
//	expression.printPostfixNotation();
//	expression.printTruthTable();
//	System.out.println("Tautology: " + String.valueOf(expression.isTautology()));

	System.out.println("!----------------------------------------------------------!");
	System.out.println("Task 4");
	bitsOperayions();
    }

    private static void bitsOperayions() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input first number");
		int n1 = Integer.parseInt(reader.readLine(), 2);
		System.out.println("Input second number");
		int n2 = Integer.parseInt(reader.readLine(), 2);

		System.out.println(String.format("bits not: %s", Integer.toBinaryString(~n1)));
		System.out.println(String.format("bits or: %s", Integer.toBinaryString(n1|n2)));
		System.out.println(String.format("bits and: %s", Integer.toBinaryString(n1&n2)));
		System.out.println(String.format("bits xor: %s", Integer.toBinaryString(n1^n2)));
	}
}
