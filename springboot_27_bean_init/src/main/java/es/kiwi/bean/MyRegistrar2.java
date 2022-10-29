package es.kiwi.bean;

import es.kiwi.bean.service.impl.BookServiceImpl2;
import es.kiwi.bean.service.impl.BookServiceImpl3;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 覆盖之前定义的bean
 */
public class MyRegistrar2 implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //1.使用元数据去做判定

        /*BeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Dog.class).getBeanDefinition();
        beanDefinition.setScope("SCOPE_SINGLETON");
        registry.registerBeanDefinition("yellow", beanDefinition);*/


        BeanDefinition beanDefinition =
                BeanDefinitionBuilder.rootBeanDefinition(BookServiceImpl3.class).getBeanDefinition();
        registry.registerBeanDefinition("bookService", beanDefinition);


    }
}
