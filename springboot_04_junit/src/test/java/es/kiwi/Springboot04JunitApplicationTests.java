package es.kiwi;

import es.kiwi.mapper.BookDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 如果不放在和引导类同级目录下，需要标注classes=引导类或者 @ContextConfiguration
 */
@SpringBootTest//(classes = Springboot04JunitApplication.class)
class Springboot04JunitApplicationTests {

    @Autowired
    private BookDAO bookDAO;

    @Test
    void contextLoads() {
        System.out.println("test.....");
        bookDAO.save();
    }

}
