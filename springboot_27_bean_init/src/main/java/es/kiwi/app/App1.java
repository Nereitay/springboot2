package es.kiwi.app;

import es.kiwi.bean.Dog;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Object cat = ctx.getBean("cat");
        System.out.println(cat);

        Dog dog = ctx.getBean(Dog.class); //不定义id名
        System.out.println(dog);

        System.out.println("Return the names of all beans defined in this factory ：");
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

    }
}
