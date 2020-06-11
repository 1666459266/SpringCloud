package com.springcloud.core.controller;

import com.springcloud.core.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    //服务降级
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id){
        String result = paymentService.paymentOK(id);
        log.info("result = " + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentTimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentTimeOut(id);
        log.info("result = " + result);
        return result;
    }

    //服务熔断
    @GetMapping("/payment/hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("result = " + result);
        return result;
    }

}