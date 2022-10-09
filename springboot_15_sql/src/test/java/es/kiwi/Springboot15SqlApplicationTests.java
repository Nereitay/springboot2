package es.kiwi;

import es.kiwi.mapper.BookDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot15SqlApplicationTests {

    @Autowired
    private BookDAO bookDAO;

    @Test
    void test() {
        bookDAO.selectById(1);
    }

}
