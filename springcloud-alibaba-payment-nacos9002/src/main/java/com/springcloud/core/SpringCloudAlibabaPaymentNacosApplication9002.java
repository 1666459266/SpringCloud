package com.springcloud.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAlibabaPaymentNacosApplication9002 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaPaymentNacosApplication9002.class,args);
    }

}
