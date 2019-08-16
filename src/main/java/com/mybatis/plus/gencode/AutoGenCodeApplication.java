package com.mybatis.plus.gencode;

import com.mybatis.plus.config.MybatisPlusDbProperties;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.logging.Logger;

@Configuration
@EnableConfigurationProperties(MybatisPlusDbProperties.class)
@AutoConfigureAfter(DataSourceAutoConfiguration.class)
public class AutoGenCodeApplication implements InitializingBean {

    Logger logger=Logger.getLogger("genCode");

    private final MybatisPlusDbProperties mybatisPlusDbProperties;

    private  final DataSource dataSource;

    public AutoGenCodeApplication(MybatisPlusDbProperties mybatisPlusDbProperties,DataSource dataSource){
        this.mybatisPlusDbProperties=mybatisPlusDbProperties;
        this.dataSource=dataSource;

    }
    /**
     * 配置完之后生成Code
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() {

        if(!mybatisPlusDbProperties.isEnable()){
            return;
        }
        logger.info("开始生成MybatisPlus代码...............");
           new SimpleAsyncTaskExecutor().execute(() -> {
               try {
                   new CodeGeneration(mybatisPlusDbProperties,dataSource).genAutoGenerator().execute();
               } catch (Exception e) {
                   logger.warning("Mybatis Plus生成Code失败"+ ExceptionUtils.getRootCause(e));
               }
           });
        logger.info("MybatisPlus代码生成完毕...............");


    }
}
