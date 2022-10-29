package es.kiwi.app;

import es.kiwi.bean.*;
import es.kiwi.config.SpringConfig4;
import es.kiwi.config.SpringConfig5;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App5 {

    public static void main(String[] args) {
        //不能用ApplicationContext，要用AnnotationConfigApplicationContext
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig5.class);
        //上下文容器对象已经初始化完毕后，手工加载bean
        ctx.registerBean("tom", Cat1.class, 0);
        ctx.registerBean("tom", Cat1.class, 1);
        ctx.registerBean("tom", Cat1.class, 2);

        ctx.register(Mouse1.class); //如果不指明beanName, bean名为类名首字母小写

        System.out.println("Return the names of all beans defined in this factory ：");
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("----------------------------------");
        System.out.println(ctx.getBean(Cat1.class)); // Cat{age=2}

    }
}
