package com.crowdcube.services;

import com.crowdcube.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionService {
    void buyProduct(Long productId, BigDecimal quantity, Double price);

    List<Transaction> getAll(Long customerId);

    void cancelTransaction(Long transactionId);
}
