package com.crowdcube.services.impl;

import com.crowdcube.model.Product;
import com.crowdcube.model.Transaction;
import com.crowdcube.model.repository.ProductRepository;
import com.crowdcube.model.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class TransactionServiceImpl implements com.crowdcube.services.TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public void buyProduct(Long productId, BigDecimal quantity, Double price) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isPresent()) {
            transactionRepository.save(Transaction.builder()
                    .product(product.get())
                    .price(price)
                    .quantity(quantity)
                    .build()
            );
        }
    }

    @Override
    public List<Transaction> getAll(Long customerId) {
        return transactionRepository.findAllByCustomerId(customerId);
    }

    @Override
    public void cancelTransaction(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }
}
