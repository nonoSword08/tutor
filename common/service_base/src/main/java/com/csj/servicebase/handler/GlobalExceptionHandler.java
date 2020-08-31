package com.csj.servicebase.handler;

import com.csj.commonutils.R;
import com.csj.servicebase.exception.tutorException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理类
 */
@RestControllerAdvice  // 被该注解注解的类能在方法中使用@ExceptionHandler注解
public class GlobalExceptionHandler {

    /**
     * 全局异常处理
     */
    @ExceptionHandler(Exception.class)  // 在出现该异常时执行此方法
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message("出现异常");
    }

    /**
     * 特定异常处理，不常用
     */
    @ExceptionHandler(ArithmeticException.class)
    public R error(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("出现ArithmeticException异常");
    }

    /**
     * 自定义异常
     */
    @ExceptionHandler(tutorException.class)
    public R error(tutorException e) {
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }

}