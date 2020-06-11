package com.springcloud.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudSleuthConsumerApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudSleuthConsumerApplication80.class,args);
    }

}
