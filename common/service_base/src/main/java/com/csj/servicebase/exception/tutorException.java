package com.csj.servicebase.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class tutorException extends RuntimeException {

    @ApiModelProperty("状态码")
    private Integer code;
    
    @ApiModelProperty("异常信息")
    private String msg;
}