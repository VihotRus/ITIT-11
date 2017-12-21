package com.mykush.core;

public class Rule {

	protected Itemset premise;
	protected Itemset conclusion;

	protected double confidence;
	protected int support;
	protected int relativeSupport;

	private int generalSupport;
	
	public Rule(Itemset premise, Itemset conclusion) {
		this.premise = premise;
		this.conclusion = conclusion;

		Itemset union = (Itemset) premise.clone();
		union.addAll(conclusion);
		support = union.getSupport();
		relativeSupport = union.getRelativeSupport();
		confidence = 100 * ((double) support) / premise.getSupport();
	}
	
	public Itemset getPremise() {
		return premise;
	}

	public Itemset getConclusion() {
		return conclusion;
	}

	public double getConfidence() {
		return confidence;
	}

	public int getSupport() {
		return support;
	}

	public int getRelativeSupport() {
		return relativeSupport;
	}

	public double confidence() {
		return confidence;
	}

	public String toString() {
		return premise
				.toString()
				.concat(" => ")
				.concat(conclusion.toString())
				.concat(" (support: " + relativeSupport + " / confidence: "
						+ confidence + ")");
	}
}
