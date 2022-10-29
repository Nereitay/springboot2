package es.kiwi.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "cartoon2")
public class CartoonProperties {

    private Cat cat;
    private Mouse mouse;
}
