package com.csj.eduservice.controller;

import java.util.List;

import com.csj.eduservice.entity.Teacher;
import com.csj.eduservice.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("")
    public List<Teacher> getAll() {
        return teacherService.list();
    }
}
