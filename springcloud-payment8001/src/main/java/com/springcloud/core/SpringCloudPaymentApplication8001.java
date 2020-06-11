package com.springcloud.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//将payment注册进Eureka Server成为服务提供者provider
@EnableDiscoveryClient//让注册中心发现并扫描到该服务
public class SpringCloudPaymentApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudPaymentApplication8001.class,args);
    }

}
