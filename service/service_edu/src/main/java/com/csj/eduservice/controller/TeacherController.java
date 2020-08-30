package com.csj.eduservice.controller;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csj.commonutils.R;
import com.csj.eduservice.entity.Teacher;
import com.csj.eduservice.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author chensijie
 * @since 2020-08-29
 */
@RestController
@RequestMapping("/eduservice/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /**
     * 获取所有讲师列表
     */
    @ApiOperation("所有讲师列表")
    @GetMapping("")
    public R getAll() {
        return R.ok().data("items", teacherService.list());
    }

    /**
     * 逻辑删除讲师
     */
    @DeleteMapping("{id}")
    public R removeTeacher(@ApiParam(name = "id", value = "讲师id", required = true) @PathVariable String id) {
        boolean result = teacherService.removeById(id);
        return result ? R.ok() : R.error();
    }

    /**
     * 讲师列表分页查询
     */
    @GetMapping("page/{current}/{limit}")
    public R page(@PathVariable Long current, @PathVariable Long limit) {
        // 创建page对象
        Page<Teacher> page = new Page<>(current, limit);
        // 将对象传入servie包装
        page = teacherService.page(page);
        // 利用page对象进行查询
        Long totol = page.getTotal(); // 总记录数
        List<Teacher> records = page.getRecords();

        //  包装返回值
        return R.ok().data("total", totol).data("items", records);
    }
}
