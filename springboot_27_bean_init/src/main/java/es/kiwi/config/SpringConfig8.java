package es.kiwi.config;

import es.kiwi.bean.MyPostProcessor;
import es.kiwi.bean.MyRegistrar;
import es.kiwi.bean.MyRegistrar2;
import es.kiwi.bean.service.impl.BookServiceImpl1;
import org.springframework.context.annotation.Import;

/**
 * MyRegister覆盖BookServiceImpl1
 * MyRegistrar 和 MyRegistrar2， 谁在后面谁覆盖前面
 * MyPostProcessor 覆盖所有
 */
@Import({BookServiceImpl1.class, MyRegistrar.class, MyRegistrar2.class, MyPostProcessor.class})
public class SpringConfig8 {
}
