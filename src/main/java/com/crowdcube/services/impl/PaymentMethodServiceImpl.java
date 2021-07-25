package com.crowdcube.services.impl;

import com.crowdcube.model.PaymentMethod;
import com.crowdcube.services.PaymentMethodService;

public class PaymentMethodServiceImpl implements PaymentMethodService {
    @Override
    public PaymentMethod create(PaymentMethod.PaymentType type, String cardNumber, String expiryDate, String ccv) {
        return PaymentMethod.builder()
                .type(type)
                .cardNumber(cardNumber)
                .expiryDate(expiryDate)
                .ccv(ccv)
                .build();
    }
}
