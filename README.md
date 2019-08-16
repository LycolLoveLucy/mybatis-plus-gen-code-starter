# mybatis-plus-gen-code-starter

#特性
1.依赖此Starter时会自动生成MP的Entity,Mapper,Service这些类。
2.生成所需的配置项暴露在外部依赖于此项目的properties文件中。

如何使用

  第一步.pom中添加依赖
  <dependency>
    <groupId>com.mybatis.plus</groupId>
    <artifactId>mybatis-plus-gen-code-starter</artifactId>
    <version>0.0.2-SNAPSHOT</version>
    <scope>compile</scope>
  </dependency>
  
  第二步在properties中配置所需选项
  
#驱动名称  
mybatis.plus.gen.driver-name=oracle.jdbc.driver.OracleDriver

  
#用户名
mybatis.plus.gen.user-name=userName

  
#登录密码
mybatis.plus.gen.password=******

#输出路径
mybatis.plus.gen.out-dir=D:/codes

#jdbcUrl
mybatis.plus.gen.jdbc-url=jdbc:oracle:thin:@ip:@port

#输出表
mybatis.plus.gen.table-list=t_account,t_role

#false将不会启动生成
mybatis.plus.gen.enable=true

#类注释的@author
mybatis.plus.gen.author=test

mybatis.plus.gen.parent=com.mybatis.plus.entity

mybatis.plus.gen.super-entity-class=com.mybatis.plus.mapper.superMapper

mybatis.plus.gen.table-prefix=t_

mybatis.plus.gen.super-entity-columns=uuid

mybatis.plus.gen.db-type=oracle

  
