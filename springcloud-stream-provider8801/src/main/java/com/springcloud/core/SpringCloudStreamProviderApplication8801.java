package com.springcloud.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudStreamProviderApplication8801 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamProviderApplication8801.class,args);
    }

}
