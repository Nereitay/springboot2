package es.kiwi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot13ConfigurationApplicationTests {

    @Value("${servers.ip-address}")
    private String msg;

    @Value("${datasource.password}")
    private String pwd;

    @Test
    void contextLoads() {
        System.out.println(msg);
        System.out.println(pwd);
    }

}
