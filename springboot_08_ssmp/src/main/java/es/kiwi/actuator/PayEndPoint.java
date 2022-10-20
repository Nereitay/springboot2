package es.kiwi.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "pay", enableByDefault = true)
public class PayEndPoint {

    @ReadOperation
    public Object getPay() {
        System.out.println("======================");
        System.out.println("========PAY===========");
        System.out.println("======================");
        Map<String, String> map = new HashMap<>();
        map.put("level 1", "300");
        map.put("level 2", "400");
        map.put("level 3", "500");
        return map;
    }
}
