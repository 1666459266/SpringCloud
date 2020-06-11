package com.springcloud.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudPaymentConsulApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudPaymentConsulApplication8001.class,args);
    }

}
