package com.mykush;

/**
 * Created by Andrii on 11.11.2017.
 */
public class Symbol {

	public SymbolType symbolType;
	public OperationType operationType;
	public Atom atom;


	public Symbol(OperationType operationType) {
		this.symbolType = SymbolType.Operation;
		this.operationType = operationType;
	}

	public Symbol(Atom atom) {
		this.symbolType = SymbolType.Atom;
		this.atom = atom;
	}

	public boolean isAtom() {
		return symbolType == SymbolType.Atom;
	}

	public boolean isOperation() {
		return symbolType == SymbolType.Operation
			&& operationType != OperationType.LBracket
			&& operationType != OperationType.RBracket;
	}

}
