package com.springcloud.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard//开启HystrixDashboard
public class SpringCloudHystrixDashboardApplication9001 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudHystrixDashboardApplication9001.class,args);
    }

}
