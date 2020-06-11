package com.springcloud.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//表明此项目是Eureka Server的注册中心 由此项目管理Eureka Server配置登记注册
public class SpringCloudEurekaServerApplication7001 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServerApplication7001.class,args);
    }

}
