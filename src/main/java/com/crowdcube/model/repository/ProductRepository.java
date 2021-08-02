package com.crowdcube.model.repository;

import com.crowdcube.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
