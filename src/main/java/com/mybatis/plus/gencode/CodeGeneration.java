package com.mybatis.plus.gencode;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.mybatis.plus.config.MybatisPlusDbProperties;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * MybatisPlus代码生成器
 */
public class CodeGeneration {

    private MybatisPlusDbProperties mybatisPlusDbProperties;

    private DataSource dataSource;

    public CodeGeneration(MybatisPlusDbProperties mybatisPlusDbProperties, DataSource dataSource) {
        this.mybatisPlusDbProperties = mybatisPlusDbProperties;
        this.dataSource=dataSource;
    }


    public AutoGenerator genAutoGenerator() throws Exception {
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        //自定义转换器
        dsc.setTypeConvert(ColumnProcessFactory.getItypeConvert(dataSource));
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setEntityLombokModel(true);
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略

        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);
        strategy.setEntityColumnConstant(true);

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(mybatisPlusDbProperties.getParent());
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("dao");
        pc.setEntity("entity");
        pc.setXml("xml");
        mpg.setPackageInfo(pc);

        //超类实体
        strategy.setTablePrefix(mybatisPlusDbProperties.getTablePrefix());// 此处可以修改为您的表前缀
        strategy.setSuperEntityClass(mybatisPlusDbProperties.getSuperEntityClass());
        gc.setAuthor(mybatisPlusDbProperties.getAuthor());// 作者
        gc.setOutputDir(mybatisPlusDbProperties.getOutDir());//输出文件路径

        strategy.setSuperEntityColumns(mybatisPlusDbProperties.getSuperEntityColumns().toArray(new String[mybatisPlusDbProperties.getSuperEntityColumns().size()]));
        strategy.setInclude(mybatisPlusDbProperties.getTableList().toArray(new String[mybatisPlusDbProperties.getTableList().size()])); // 需要生成的表
        dsc.setDbType(mybatisPlusDbProperties.getDbType());
        dsc.setDriverName(mybatisPlusDbProperties.getDriverName());
        dsc.setUsername(mybatisPlusDbProperties.getUserName());
        dsc.setPassword(mybatisPlusDbProperties.getPassword());
        dsc.setUrl(mybatisPlusDbProperties.getJdbcUrl());

        mpg.setTemplateEngine(new CustomTemplate());

        return mpg;
    }

    private static  class CustomTemplate extends VelocityTemplateEngine {

        @Override
        public Map<String, Object> getObjectMap(TableInfo tableInfo) {
           Map<String,Object> objectMap=  super.getObjectMap(tableInfo);
            objectMap.put("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            return objectMap;
        }

    }



}