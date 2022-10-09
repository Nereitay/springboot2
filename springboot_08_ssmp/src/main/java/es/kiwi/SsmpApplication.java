package es.kiwi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SsmpApplication {

    public static void main(String[] args) {
        /*System.out.println(Arrays.toString(args));
        SpringApplication.run(SsmpApplication.class, args);*/

        /*String[] arg = new String[1];
        arg[0] = "--server.port=8083";
        SpringApplication.run(SsmpApplication.class, arg); // Tomcat initialized with port(s): 8083 (http)*/

        //可以在启动boot程序时断块读取外部临时配置对应的入口，也就是去掉读取外部参数的形参
        SpringApplication.run(SsmpApplication.class);
    }

}
