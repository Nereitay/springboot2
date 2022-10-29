package es.kiwi.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * 在使用@Import的类中动态加载bean
 */
public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        System.out.println("提示：" + importingClassMetadata.getClassName()); // 提示：es.kiwi.config.SpringConfig6

        System.out.println(importingClassMetadata.hasAnnotation(
                "org.springframework.context.annotation.Configuration"));

        Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(
                "org.springframework.context.annotation.ComponentScan");
        System.out.println(attributes);

//        return new String[]{"es.kiwi.bean.Dog", "es.kiwi.bean.Cat"}; //全路径类名

        /*
        可以设置各种条件的判定，判定完毕后，决定是否装载指定的bean
         */
        if (importingClassMetadata.hasAnnotation(
                "org.springframework.context.annotation.Configuration"))
            return new String[]{"es.kiwi.bean.Dog"};

        return new String[]{"es.kiwi.bean.Cat"};
    }
}
