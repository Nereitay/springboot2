package es.kiwi;

import es.kiwi.mapper.BookDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot07DruidApplicationTests {

    @Autowired
    private BookDAO bookDAO;

    @Test
    void contextLoads() {
        bookDAO.getById(3);
    }

}
