package es.kiwi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot06MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot06MybatisPlusApplication.class, args);
    }

    /*
    * 1.手工添加MyBatis-Plus对应的starter
      2.数据层接口使用BaseMapper简化开发
      3.需要使用的第三方技术无法通过勾选确定时，需要手工添加坐标
    *
    * */

}
