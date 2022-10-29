package es.kiwi.config;

import es.kiwi.bean.MyImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@ComponentScan(basePackages = "es.kiwi")
@Import(MyImportSelector.class)
public class SpringConfig6 {
}
