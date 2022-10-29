package es.kiwi.app;

import es.kiwi.config.SpringConfigProxyBeanMethods;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppProxyBeanMethods {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfigProxyBeanMethods.class);

        System.out.println("Return the names of all beans defined in this factory ：");
        String[] names = ctx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("------------ProxyBeanMethods = true 是一个代理对象,创建单例bean CGLIB-------------");
        SpringConfigProxyBeanMethods springConfigProxyBeanMethods = ctx.getBean("springConfigProxyBeanMethods",
                SpringConfigProxyBeanMethods.class);
        System.out.println(springConfigProxyBeanMethods.cat()); //方法调用拿到代理对象创建的单例bean对象
        System.out.println(springConfigProxyBeanMethods.cat());
        System.out.println(springConfigProxyBeanMethods.cat());

    }
}
