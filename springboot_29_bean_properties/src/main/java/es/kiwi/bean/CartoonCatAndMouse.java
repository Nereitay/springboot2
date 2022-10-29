package es.kiwi.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "cartoon")
public class CartoonCatAndMouse {

    private Cat cat;
    private Mouse mouse;

    /*public CartoonCatAndMouse() {
        cat = new Cat();
        cat.setName("Tom");
        cat.setAge(3);

        mouse = new Mouse();
        mouse.setName("Jerry");
        mouse.setAge(2);
    }*/

    public void play() {
        System.out.println(
                cat.getAge() + " years old " + cat.getName() + " and " + mouse.getAge() + " years old " + mouse.getName());
    }
}
