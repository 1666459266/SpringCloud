package com.springcloud.core.controller;

import com.springcloud.core.entity.CommonResult;
import com.springcloud.core.entity.Payment;
import com.springcloud.core.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * RestTemplate提供了多种便捷访问远程HTTP服务方法
 * 是一种便携的访问restful服务模板类 是Spring提供的用于访问Rest服务的客户端模板工具集
 * 读操作用Get 写操作用Post
 */
@RestController
@Slf4j
public class OrderController {

    //单机版 订单服务地址不能写死
    //public static final String PAYMENT_URL = "http://localhost:8001";
    //微服务集群 只关心微服务名称 Ribbon和Eureka整合后直接调用服务而不用关心地址和端口且服务还有负载均衡功能
    public static final String PAYMENT_URL = "http://SPRINGCLOUD-PAYMENT";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired//使用自定义的轮询算法
    private LoadBalancer loadBalancer;
    @Autowired//可以通过服务发现来获得该服务信息
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/add")
    public CommonResult<Payment> add(Payment payment) {
        log.info("客户调用添加接口");
        //三个参数 REST请求地址 请求参数 HTTP响应转换被转换成的对象类型
        return restTemplate.postForObject(PAYMENT_URL + "/payment/add", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        log.info("客户调用查询接口");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping("/consumer/payment1/add")
    public CommonResult<Payment> add1(Payment payment) {
        return restTemplate.postForEntity(PAYMENT_URL + "/payment/add", payment, CommonResult.class).getBody();
    }

    @GetMapping("/consumer/payment1/get/{id}")
    public CommonResult<Payment> getPaymentId1(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<>(500, "操作失败");
        }
    }

    //使用自定义的轮询算法
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PAYMENT");
        if (instances == null   || instances.size() <= 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

}
