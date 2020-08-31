package com.csj.eduservice.controller;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csj.commonutils.R;
import com.csj.eduservice.entity.Teacher;
import com.csj.eduservice.entity.vo.TeacherQuery;
import com.csj.eduservice.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @ApiOperation("所有讲师列表")
    @GetMapping("")
    public R getAll() {
        return R.ok().data("items", teacherService.list());
    }

    @ApiOperation("逻辑删除讲师")
    @DeleteMapping("{id}")
    public R removeTeacher(@ApiParam(name = "id", value = "讲师id", required = true) @PathVariable String id) {
        boolean result = teacherService.removeById(id);
        return result ? R.ok() : R.error();
    }

    @ApiOperation("讲师列表分页查询")
    @GetMapping("page/{current}/{limit}")
    public R page(@PathVariable Long current, @PathVariable Long limit) {
        // 创建page对象
        Page<Teacher> page = new Page<>(current, limit);
        // 将对象传入servie包装
        page = teacherService.page(page);
        // 利用page对象进行查询
        Long totol = page.getTotal(); // 总记录数
        List<Teacher> records = page.getRecords();

        // 包装返回值
        return R.ok().data("total", totol).data("items", records);
    }

    @ApiOperation("讲师列表分页带条件查询")
    @GetMapping("pageCondition/{current}/{limit}")
    public R pageConfition(@PathVariable Long current, @PathVariable Long limit, TeacherQuery teacherQuery) {
        // 创建page对象
        Page<Teacher> page = new Page<>(current, limit);

        // 创建wrapper对象，构建查询条件
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        // 向wrapper中配置查询条件
        // 判断条件值是否为空，如果不为空则拼接上条件
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
        if (!StringUtils.isEmpty(name)) {
            wrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(level)) {
            wrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_create", end);
        }

        // 将page和wrapper对象传入service进行包装
        teacherService.page(page, wrapper);

        // 利用page对象进行查询
        Long totol = page.getTotal(); // 总记录数
        List<Teacher> records = page.getRecords();

        // 包装返回值
        return R.ok().data("total", totol).data("items", records);
    }

    @ApiOperation("添加讲师")
    @PostMapping("")
    public R add(@RequestBody Teacher teacher) {
        boolean result = teacherService.save(teacher);
        return result ? R.ok() : R.error();
    }

    @ApiOperation("查询讲师")
    @GetMapping("{id}")
    public R get(@PathVariable String id) {
        return R.ok().data("teacher", teacherService.getById(id));
    }

    @ApiOperation("修改讲师")
    @PutMapping("{id}")
    public R update(@PathVariable String id, @RequestBody Teacher teacher) {
        teacher.setId(id);
        boolean result = teacherService.updateById(teacher);
        return result ? R.ok() : R.error();
    }

}
