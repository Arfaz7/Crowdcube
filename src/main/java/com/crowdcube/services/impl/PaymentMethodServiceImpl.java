package com.crowdcube.services.impl;

import com.crowdcube.model.PaymentMethod;
import com.crowdcube.services.PaymentMethodService;

public class PaymentMethodServiceImpl implements PaymentMethodService {
    @Override
    public PaymentMethod create() {
        return new PaymentMethod();
    }
}
