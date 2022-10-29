package es.kiwi.bean;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

@Data
@EnableConfigurationProperties(CartoonProperties.class) //设定使用属性类时加载bean
@ConditionalOnClass(name = "org.springframework.data.redis.core.RedisOperations")
public class CartoonCatAndMouse3 implements ApplicationContextAware{

    private CartoonProperties cartoonProperties;

    private ApplicationContext applicationContext;

    public CartoonCatAndMouse3(CartoonProperties cartoonProperties) {
        this.cartoonProperties = cartoonProperties;
    }

    public void play() {
        Cat cat = cartoonProperties.getCat();
        Mouse mouse = cartoonProperties.getMouse();
        System.out.println(
                cat.getAge() + " years old " + cat.getName() + " and "
                        + mouse.getAge() + " years old " + mouse.getName());

        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
