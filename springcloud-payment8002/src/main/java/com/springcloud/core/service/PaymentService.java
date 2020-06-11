package com.springcloud.core.service;

import com.springcloud.core.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    public int add(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
