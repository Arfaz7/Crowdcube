package com.crowdcube.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="payment_method")
public class PaymentMethod {
    public enum PaymentType {
        STRIPE,
        SAGEPAY,
        BRAINTREE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PaymentType type;
    private String cardNumber;
    private String expiryDate;
    private String ccv;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
