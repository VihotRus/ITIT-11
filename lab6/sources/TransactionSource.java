package com.mykush.sources;

import com.mykush.core.Itemset;

import java.util.List;

public interface TransactionSource {
	List<Itemset> generate();
}
