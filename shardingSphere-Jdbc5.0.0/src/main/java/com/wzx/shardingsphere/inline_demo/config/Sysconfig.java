package com.wzx.shardingsphere.inline_demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Calendar;

/**
 * meta
 *
 * @author create by wangzx on 2023/5/5 11:54
 * @version meta v1.0.0
 */
@Configuration
@Order(1)
public class Sysconfig {


    @Resource
    private DataSource dataSource;
}
