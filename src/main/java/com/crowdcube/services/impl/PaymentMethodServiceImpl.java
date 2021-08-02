package com.crowdcube.services.impl;

import com.crowdcube.model.PaymentMethod;
import com.crowdcube.model.repository.PaymentMethodRepository;
import com.crowdcube.services.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Override
    public PaymentMethod create(PaymentMethod.PaymentType type, String cardNumber, String expiryDate, String ccv) {
        return paymentMethodRepository.save(PaymentMethod.builder()
                .type(type)
                .cardNumber(cardNumber)
                .expiryDate(expiryDate)
                .ccv(ccv)
                .build());
    }

    @Override
    public PaymentMethod update(PaymentMethod pm) {
        return paymentMethodRepository.save(pm);
    }

    @Override
    public boolean delete(Long paymentMethodId) {
        paymentMethodRepository.deleteById(paymentMethodId);
        return !paymentMethodRepository.findById(paymentMethodId).isPresent();
    }

    @Override
    public List<PaymentMethod> getAll(Long userId) {
        return paymentMethodRepository.findAllByUserId(userId);
    }
}
