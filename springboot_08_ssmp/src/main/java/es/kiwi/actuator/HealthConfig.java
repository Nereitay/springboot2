package es.kiwi.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Configuration
public class HealthConfig extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        boolean condition = true;
        if (condition) {
            builder.status(Status.UP);

            builder.withDetail("runTime", new Date()).withDetail("chain", "test");
            Map<String, Object> infoMap = new HashMap<>();
            infoMap.put("buildTime", "2006");
            builder.withDetails(infoMap);
//            builder.up();
        } else {
            builder.status(Status.OUT_OF_SERVICE);

            builder.withDetail("上线了吗？", "并没有");
//            builder.down();
        }
    }
}
