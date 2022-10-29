package es.kiwi.config;

import es.kiwi.bean.MyImportSelector;
import org.springframework.context.annotation.Import;

@Import(MyImportSelector.class)
public class SpringConfig {
}
