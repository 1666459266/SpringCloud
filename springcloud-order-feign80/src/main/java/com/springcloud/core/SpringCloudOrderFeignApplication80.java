package com.springcloud.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients//使用Feign激活并开启
public class SpringCloudOrderFeignApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudOrderFeignApplication80.class,args);
    }

}
