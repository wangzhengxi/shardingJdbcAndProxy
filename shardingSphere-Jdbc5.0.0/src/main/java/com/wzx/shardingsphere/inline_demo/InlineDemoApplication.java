package com.wzx.shardingsphere.inline_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
@MapperScan("com.wzx.shardingsphere.inline_demo.mapper")
@SpringBootApplication
@EnableConfigurationProperties
public class InlineDemoApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(InlineDemoApplication.class, args);
    }
}
