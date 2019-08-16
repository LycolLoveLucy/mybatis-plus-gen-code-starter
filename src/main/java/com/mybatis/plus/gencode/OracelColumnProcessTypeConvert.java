package com.mybatis.plus.gencode;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

/**
 * Oracle Column自定义转换器
 */
public class OracelColumnProcessTypeConvert extends OracleTypeConvert {

    @Override
    public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
        String t = fieldType.toLowerCase();
        if (t.contains("clob")) {
            return DbColumnType.STRING;
        } else if (t.contains("blob")) {
            return DbColumnType.STRING;
        } else if (t.contains("binary")) {
            return DbColumnType.STRING;
        }
        return  super.processTypeConvert(globalConfig,fieldType);

    }

}