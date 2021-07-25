package com.crowdcube.services;

import com.crowdcube.model.PaymentMethod;
import org.springframework.stereotype.Service;

@Service
public interface PaymentMethodService {
    PaymentMethod create();
}
