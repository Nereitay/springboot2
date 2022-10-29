package es.kiwi.app;

import es.kiwi.bean.Dog;
import es.kiwi.config.SpringConfig4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App4 {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig4.class);

        System.out.println("Return the names of all beans defined in this factory ：");
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("----------------------------------");
        System.out.println(ctx.getBean(Dog.class)); //全路径类名 es.kiwi.bean.Dog@42f93a98

    }
}
