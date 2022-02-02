package com.dagacube.casinopoc.interfaces;

import java.util.Comparator;

import com.dagacube.casinopoc.model.Transaction;

public class TransactionDateAscComparator implements Comparator {

	@Override
	public int compare(Object a, Object b) {
		Transaction transaction_a = (Transaction)a;
		Transaction transaction_b = (Transaction)b;

		if (transaction_a.getTransactionDate().after(transaction_b.getTransactionDate())) {
			return 1;
		} else if (transaction_b.getTransactionDate().after(transaction_a.getTransactionDate())) {
			return -1;
		}else {
			return 0;
		}
	}
	
}
