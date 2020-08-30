package com.csj.eduservice.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.csj.eduservice.mapper")
public class EduConfig {
    /**
     * mp分页插件
     */
    @Bean
    public PaginationInterceptor paginationIntercepeter() {
        return new PaginationInterceptor();
    }
}