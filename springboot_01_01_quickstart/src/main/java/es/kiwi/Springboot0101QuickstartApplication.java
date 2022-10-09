package es.kiwi;

import es.User;
import es.kiwi.controller.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot0101QuickstartApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Springboot0101QuickstartApplication.class, args);

        BookController bean = ctx.getBean(BookController.class);
        System.out.println("bean========>" + bean);

        /*User bean2 = ctx.getBean(User.class);
        System.out.println("bean========>" + bean2);*/
    }

}
