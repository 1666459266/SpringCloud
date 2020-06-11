package com.springcloud.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.springcloud.core.dao"})
public class MyBatisConfig {
}
