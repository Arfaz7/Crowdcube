package com.crowdcube.model.repository;

import com.crowdcube.model.PaymentMethod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Long> {

}
