package com.springcloud.core.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.core.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")//全局服务降级
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentOk(id);
        return result;
    }

//    @HystrixCommand(fallbackMethod = "paymentTimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentTimeOut(@PathVariable("id") Integer id){
        //int age = 10 /0;
        String result = paymentHystrixService.paymentTimeOut(id);
        return result;
    }

    public String paymentTimeOutHandler(Integer id){
        return "支付系统较忙，请稍后再试或内部出错";
    }

    //全局服务降级方法 不能带参数 否则@DefaultProperties将找不到该方法
    public String paymentGlobalFallbackMethod(){
        return "全局服务降级异常";
    }

}
