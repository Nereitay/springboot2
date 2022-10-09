package es.kiwi;

import es.kiwi.config.MsgConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import({MsgConfig.class}) //MsgConfig上可以不用注解@Configuration
public class ConfigurationTest {

    @Autowired
    private String msg;

    @Test
    void TestConfiguration() {
        System.out.println(msg);
    }

}
