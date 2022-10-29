package com.mapache.autoconfig;

import com.mapache.interceptor.SpringMvcConfig;
import com.mapache.properties.IpProperties;
import com.mapache.service.IpCountService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
//@EnableConfigurationProperties(IpProperties.class)
@Import({IpProperties.class, SpringMvcConfig.class}) //被引入第三方时，不能被自动扫描，需要手动添加@Import导入
public class IpAutoConfiguration {

    @Bean
    public IpCountService ipCountService() {
        return new IpCountService();
    }
}
