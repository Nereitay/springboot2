package es.kiwi.config;

import es.kiwi.bean.Dog;
import es.kiwi.bean.DogFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//@Configuration //可以不加
@ComponentScan({"es.kiwi.bean", "es.kiwi.config"}) //这个注解的类也会成为一个bean
public class SpringConfigFactoryBean {

    /*@Bean
    public Dog dog() {
        return new Dog();
    }*/

    @Bean
    public DogFactoryBean dog() {
        return new DogFactoryBean();
    }
}
