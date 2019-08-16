package com.mybatis.plus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "mybatis.plus.gen")
public class MybatisPlusDbProperties {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 输出路径
     */
    private String outDir;

    /**
     * entity父类
     */
    private String superEntityClass;

    /**
     * 生成的输出表集合,用逗号隔开即可
     */
    private List<String> tableList;


    /**
     * Jdbc链接
     */
    private String  jdbcUrl;

    /**
     * 驱动加载类
     */
    private String driverName;

    /**
     * 是否开启启动
     */
    private  boolean enable;

    /**
     * 作者
     */
    private  String author;

    /**
     * 设置表的前缀
     */
    private  String tablePrefix;

    /**
     * Entity父类的属性
     */
    private  List<String> superEntityColumns;

    /**
     * Mapper父类
     */
    private  String parent;

    private DbType dbType;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getOutDir() {
        return outDir;
    }

    public void setOutDir(String outDir) {
        this.outDir = outDir;
    }

    public String getSuperEntityClass() {
        return superEntityClass;
    }

    public void setSuperEntityClass(String superEntityClass) {
        this.superEntityClass = superEntityClass;
    }

    public List<String> getTableList() {
        return tableList;
    }

    public void setTableList(List<String> tableList) {
        this.tableList = tableList;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }

    public List<String> getSuperEntityColumns() {
        return superEntityColumns;
    }

    public void setSuperEntityColumns(List<String> superEntityColumns) {
        this.superEntityColumns = superEntityColumns;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public DbType getDbType() {
        return dbType;
    }

    public void setDbType(DbType dbType) {
        this.dbType = dbType;
    }
}
