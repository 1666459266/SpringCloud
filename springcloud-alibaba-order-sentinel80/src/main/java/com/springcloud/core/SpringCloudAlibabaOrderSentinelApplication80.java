package com.springcloud.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients//使用Feign激活并开启
public class SpringCloudAlibabaOrderSentinelApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaOrderSentinelApplication80.class,args);
    }

}
