package com.csj.eduservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.csj.eduservice.mapper")
public class EduConfig {

}