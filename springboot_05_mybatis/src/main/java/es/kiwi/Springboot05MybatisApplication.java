package es.kiwi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot05MybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot05MybatisApplication.class, args);
    }

    /*
        整合第三方技术
    *   1. 勾选MyBatis技术，也就是导入MyBatis对应的starter
        2. 数据库连接相关信息转换成配置
        3. 数据库SQL映射需要添加@Mapper被容器识别到

    *   SpringBoot整合MyBatis常见问题处理
        1.MySQL 8.X驱动强制要求设置时区
            修改url，添加serverTimezone设定
            修改MySQL数据库配置（略）
        2.驱动类过时，提醒更换为com.mysql.cj.jdbc.Driver
    */
}
