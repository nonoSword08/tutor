package com.csj;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

// 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = "/root/tutor/service/service_edu";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("chensijie");
        gc.setOpen(false);  // 生成后是否打开文件
        gc.setSwagger2(true); // 实体属性 Swagger2 注解
        gc.setFileOverride(true);  // 是否覆盖原文件
        gc.setServiceName("%sService");  // service接口命名规则，默认是I%sService
        gc.setIdType(IdType.ASSIGN_ID); // 主键生成策略
        gc.setDateType(DateType.ONLY_DATE); // 日期类型
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/tutor?serverTimezone=Asia/Shanghai");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("csj123.");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.csj");
        pc.setModuleName("eduservice");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("edu_teacher"); // 需要逆向的表
        strategy.setNaming(NamingStrategy.underline_to_camel); // 表名下划线转驼峰
        strategy.setTablePrefix("edu_"); // 指名表使用的前缀，生成实体时会去掉
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true); // 使用Lombok
        strategy.setRestControllerStyle(true); // restful api风格的控制层
        strategy.setControllerMappingHyphenStyle(false);
        // strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);

        mpg.execute();
    }

}
