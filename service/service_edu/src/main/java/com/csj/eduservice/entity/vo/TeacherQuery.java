package com.csj.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 封装Teacher的查询条件
 */
@Data
public class TeacherQuery {
    @ApiModelProperty("讲师名称，模糊查询")
    private String name;

    @ApiModelProperty("头衔：1高级 2首席")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    private String begin;

    @ApiModelProperty(value = "查询结束时间", example = "2019-01-01 10:10:10")
    private String end;
}