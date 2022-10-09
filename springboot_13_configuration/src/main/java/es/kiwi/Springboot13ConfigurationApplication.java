package es.kiwi;

import com.alibaba.druid.pool.DruidDataSource;
import es.kiwi.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({ServerConfig.class})
public class Springboot13ConfigurationApplication {

    @Bean
    /*Canonical names should be kebab-case ('-' separated), lowercase alpha-numeric characters and must start with a letter*/
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource datasource() {
        DruidDataSource ds = new DruidDataSource();
//        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return ds;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Springboot13ConfigurationApplication.class, args);
        ServerConfig serverConfig = ctx.getBean(ServerConfig.class);
        System.out.println(serverConfig);

        DruidDataSource ds = ctx.getBean(DruidDataSource.class);
        System.out.println(ds.getDriverClassName());
    }

}
