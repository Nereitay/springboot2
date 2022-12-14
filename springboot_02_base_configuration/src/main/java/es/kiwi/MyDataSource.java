package es.kiwi;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "datasource")
public class MyDataSource {

    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
