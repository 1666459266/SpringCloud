package com.springcloud.core.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentService {

    //服务降级
    public String paymentOK(Integer id);

    public String paymentTimeOut(Integer id);

    //服务熔断
    public String paymentCircuitBreaker(@PathVariable("id") Integer id);

}
