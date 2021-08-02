package com.crowdcube.model.repository;

import com.crowdcube.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    List<Transaction> findAllByCustomerId(Long customerId);
}
