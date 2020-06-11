package com.springcloud.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAlibabaOrderNacosApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaOrderNacosApplication80.class,args);
    }

}
