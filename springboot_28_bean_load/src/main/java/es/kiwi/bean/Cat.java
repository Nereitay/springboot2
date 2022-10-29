package es.kiwi.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Component;

@Component("tom")
@ConditionalOnBean(name = "jerry")
@ConditionalOnNotWebApplication
public class Cat {
}
