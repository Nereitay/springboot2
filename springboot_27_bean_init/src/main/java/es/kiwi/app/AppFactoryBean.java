package es.kiwi.app;

import es.kiwi.config.SpringConfigFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppFactoryBean {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfigFactoryBean.class);

        System.out.println("Return the names of all beans defined in this factory ：");
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println(ctx.getBean("dog"));
        System.out.println(ctx.getBean("dog"));
        System.out.println(ctx.getBean("dog"));

    }
}
