package es.kiwi.app;

import es.kiwi.config.SpringConfig7;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App7 {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig7.class);

        System.out.println("Return the names of all beans defined in this factory ：");
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("----------------------------------");


    }
}
