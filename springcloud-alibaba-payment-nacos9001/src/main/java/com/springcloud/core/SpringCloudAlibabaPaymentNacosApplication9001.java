package com.springcloud.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient//让注册中心发现并扫描到该服务
public class SpringCloudAlibabaPaymentNacosApplication9001 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaPaymentNacosApplication9001.class,args);
    }

}
