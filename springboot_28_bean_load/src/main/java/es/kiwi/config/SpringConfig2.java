package es.kiwi.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;

@ComponentScan("es.kiwi.bean")
public class SpringConfig2 {

    @Bean
    @ConditionalOnClass(name="com.mysql.cj.jdbc.Driver")
    public DruidDataSource dataSource() {
        return new DruidDataSource();
    }
}
