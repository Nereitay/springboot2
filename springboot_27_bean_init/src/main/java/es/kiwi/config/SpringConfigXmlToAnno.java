package es.kiwi.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ImportResource("applicationContext1.xml") //系统迁移， 导入原始配置文件
@ComponentScan("es.kiwi.bean")
public class SpringConfigXmlToAnno {
}
