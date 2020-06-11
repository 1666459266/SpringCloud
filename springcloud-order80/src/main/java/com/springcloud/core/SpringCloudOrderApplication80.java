package com.springcloud.core;

import com.springcloud.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient//将order注册进Eureka Server成为服务消费者consumer
//@RibbonClient(name = "SPRINGCLOUD-PAYMENT",configuration = MySelfRule.class)//启动微服务时加载自定义的Ribbon配置类 从而使配置类生效
public class SpringCloudOrderApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudOrderApplication80.class,args);
    }

}
