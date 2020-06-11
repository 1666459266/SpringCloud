package com.springcloud.core.service;

import com.springcloud.core.entity.CommonResult;
import com.springcloud.core.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回------PaymentFallbackService");
    }

}
