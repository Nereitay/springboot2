package es.kiwi.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Configuration
//@Component
public class InfoConfig implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("runTime", new Date()).withDetail("chain", "test");
        Map<String, Object> infoMap = new HashMap<>();
        infoMap.put("buildTime", "2006");
        builder.withDetails(infoMap);
    }
}
