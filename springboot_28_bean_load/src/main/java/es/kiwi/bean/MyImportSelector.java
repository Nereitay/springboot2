package es.kiwi.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        try {
            Class<?> clazz = Class.forName("es.kiwi.bean.Wolf");
            if (clazz != null)
                return new String[]{"es.kiwi.bean.Cat"};
        } catch (Exception e) {
//            e.printStackTrace();
            return new String[0];
        }

        return null;
    }
}
