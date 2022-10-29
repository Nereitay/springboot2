package es.kiwi.bean;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

@Data
@EnableConfigurationProperties(CartoonProperties.class) //设定使用属性类时加载bean
public class CartoonCatAndMouse2 implements ApplicationContextAware {

    private Cat cat;
    private Mouse mouse;

    private CartoonProperties cartoonProperties;

    /**
     * 使用构造器注入，也可以用@Autowired
     * @param cartoonProperties
     */
    public CartoonCatAndMouse2(CartoonProperties cartoonProperties) {
        this.cartoonProperties = cartoonProperties;

        cat = new Cat();
        cat.setName(cartoonProperties.getCat() != null
                && StringUtils.hasText(cartoonProperties.getCat().getName())
                ? cartoonProperties.getCat().getName()
                : "Tom");
        cat.setAge(cartoonProperties.getCat() != null
                && cartoonProperties.getCat().getAge() != null
                ? cartoonProperties.getCat().getAge()
                : 3);

        mouse = new Mouse();
        mouse.setName("Jerry");
        mouse.setAge(2);
    }

    public void play() {
        System.out.println(
                cat.getAge() + " years old " + cat.getName() + " and "
                        + mouse.getAge() + " years old " + mouse.getName());

        String[] beans = applicationContext.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
