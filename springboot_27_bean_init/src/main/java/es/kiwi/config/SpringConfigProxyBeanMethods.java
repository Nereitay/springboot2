package es.kiwi.config;

import es.kiwi.bean.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class SpringConfigProxyBeanMethods {

    @Bean
    public Cat cat() {
        return new Cat();
    }
}
