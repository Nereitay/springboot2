package es.kiwi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration //可以不加
@ComponentScan({"es.kiwi.bean", "es.kiwi.config"}) //这个注解的类也会成为一个bean
public class SpringConfig3 {
}
