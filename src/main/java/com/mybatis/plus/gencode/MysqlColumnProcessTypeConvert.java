package com.mybatis.plus.gencode;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

/**
 * Mysql 自定义ColumnConvert
 */
public class MysqlColumnProcessTypeConvert extends MySqlTypeConvert {

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
