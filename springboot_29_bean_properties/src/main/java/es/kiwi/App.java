package es.kiwi;

import es.kiwi.bean.CartoonCatAndMouse;
import es.kiwi.bean.CartoonCatAndMouse2;
import es.kiwi.bean.CartoonCatAndMouse3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication(excludeName = "org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration")
@Import(CartoonCatAndMouse2.class)
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class);

//        CartoonCatAndMouse bean = ctx.getBean(CartoonCatAndMouse.class);

//        CartoonCatAndMouse2 bean = ctx.getBean(CartoonCatAndMouse2.class);

        CartoonCatAndMouse3 bean = ctx.getBean(CartoonCatAndMouse3.class); //spring.factories中注入
        bean.play();
    }
}
