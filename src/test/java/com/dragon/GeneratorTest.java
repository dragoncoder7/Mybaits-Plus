package com.dragon;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

import java.sql.Types;
import java.util.Collections;

public class GeneratorTest {

    @Test
    public void  test(){
        System.out.println(System.getProperty("user.dir"));
    }
    @Test
//    public void generate() {
//        AutoGenerator generator = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig config = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
//        // 设置输出到的目录
//        config.setOutputDir(projectPath + "/src/main/java");
//        config.setAuthor("狸生");
//        // 生成结束后是否打开文件夹
//        config.setOpen(false);
//
//        // 全局配置添加到 generator 上
//        generator.setGlobalConfig(config);
//
//        // 数据源配置
//        DataSourceConfig dataSourceConfig = new DataSourceConfig();
//        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/yupi?serverTimezone=Asia/Shanghai");
//        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
//        dataSourceConfig.setUsername("root");
//        dataSourceConfig.setPassword("root");
//
//        // 数据源配置添加到 generator
//        generator.setDataSource(dataSourceConfig);
//
//        // 包配置, 生成的代码放在哪个包下
//        PackageConfig packageConfig = new PackageConfig();
//        packageConfig.setParent("com.dragon.mp.generator");
//
//        // 包配置添加到 generator
//        generator.setPackageInfo(packageConfig);
//
//        // 策略配置
//        StrategyConfig strategyConfig = new StrategyConfig();
//        // 下划线驼峰命名转换
//        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
//        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
//        // 开启lombok
//        strategyConfig.setEntityLombokModel(true);
//        // 开启RestController
//        strategyConfig.setRestControllerStyle(true);
//        generator.setStrategy(strategyConfig);
//        generator.setTemplateEngine(new FreemarkerTemplateEngine());
//
//        // 开始生成
//        generator.execute();
//    }

    public void test1() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/yupi?serverTimezone=Asia/Shanghai", "root", "root")
                .globalConfig(builder -> {
                    builder.author("mengxiaolong") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir("F:\\maoyunlong\\demo\\src\\main\\java"); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent("com.dragon.mybatisplus.samples.generator") // 设置父包名
                                .moduleName("test") // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, "F:\\maoyunlong\\demo\\src\\main\\java")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                        builder.addInclude("user") // 设置需要生成的表名
                                //.addTablePrefix("t_", "c_") // 设置过滤表前缀
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
