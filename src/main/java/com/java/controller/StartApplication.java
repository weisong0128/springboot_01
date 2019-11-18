package com.java.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * description: 描述
 * author: ws
 * time: 2019/11/14 22:24
 */
@SpringBootApplication(scanBasePackages = {"com.java.controller","com.java.service.impl","com.java.tasks"})
@MapperScan(basePackages = {"com.java.mapper"}) //开启mybatis注解
//@EnableScheduling //开启定时任务
//@ServletComponentScan(basePackages = "com.java.filters") //开启过滤器
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
