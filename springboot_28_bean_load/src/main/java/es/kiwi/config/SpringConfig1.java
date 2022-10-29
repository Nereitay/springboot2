package es.kiwi.config;

import es.kiwi.bean.Cat;
import es.kiwi.bean.Mouse;
import es.kiwi.bean.MyImportSelector;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;

//@Import(Mouse.class)
@ComponentScan("es.kiwi.bean")
public class SpringConfig1 {

    /*@Bean
//    @ConditionalOnClass(Mouse.class)
//    @ConditionalOnClass(name = "es.kiwi.bean.Wolf")
//    @ConditionalOnMissingClass("es.kiwi.bean.Wolf")
//    @ConditionalOnBean(name = "es.kiwi.bean.Mouse")
    *//*@ConditionalOnBean(name = "jerry")
    @ConditionalOnMissingClass("es.kiwi.bean.Dog")*//*
    @ConditionalOnNotWebApplication
    public Cat tom() {
        return new Cat();
    }*/
}
