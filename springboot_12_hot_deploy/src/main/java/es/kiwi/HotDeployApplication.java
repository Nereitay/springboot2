package es.kiwi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotDeployApplication {

    public static void main(String[] args) {
        //覆盖配置文件属性， 禁用热部署
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(HotDeployApplication.class);
    }

}
