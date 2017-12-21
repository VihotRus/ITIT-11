package com.mykush;

import com.mykush.core.AprioriAlgorithm;
import com.mykush.core.Rule;
import com.mykush.sources.CsvFileSource;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		AprioriAlgorithm algorithm = new AprioriAlgorithm();
		algorithm.setSource(new CsvFileSource("resources/inputData.csv"));
		algorithm.getTransactions();
		List<Rule> result = algorithm.run(60, 80);
		System.out.println(result.size());
	}
}
