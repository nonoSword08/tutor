package com.csj.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.csj"})  // 扫描com.csj下所有的类，而不是只扫描com.csj.eduservice
public class EduApplicaton {
    public static void main(String[] args) {
        SpringApplication.run(EduApplicaton.class, args);
    }
}