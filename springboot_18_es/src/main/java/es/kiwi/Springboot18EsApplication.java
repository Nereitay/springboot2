package es.kiwi;

import es.kiwi.config.RestHighLevelClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({RestHighLevelClientConfig.class})
public class Springboot18EsApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot18EsApplication.class, args);
    }

}
