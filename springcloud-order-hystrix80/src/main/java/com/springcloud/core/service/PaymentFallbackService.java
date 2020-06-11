package com.springcloud.core.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentOk(Integer id) {
        return "PaymentFallbackService Fallback paymentOk";
    }

    @Override
    public String paymentTimeOut(Integer id) {
        return "PaymentFallbackService Fallback paymentTimeOut";
    }

}
