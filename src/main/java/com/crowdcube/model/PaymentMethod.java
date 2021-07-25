package com.crowdcube.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod {
    public enum PaymentType {
        STRIPE,
        SAGEPAY,
        BRAINTREE
    }

    private PaymentType type;
    private String cardNumber;
    private String expiryDate;
    private String ccv;
}
