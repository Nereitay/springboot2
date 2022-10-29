package es.kiwi.config;

import es.kiwi.bean.Dog;
import org.springframework.context.annotation.Import;

@Import({Dog.class, DbConfig.class}) //@Import 被导入的bean无需注解声明为bean
public class SpringConfig4 {
}
