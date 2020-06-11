package com.springcloud.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaServerApplication7003 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServerApplication7003.class,args);
    }

}
