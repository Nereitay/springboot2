package es.kiwi;

import es.kiwi.model.Book;
import es.kiwi.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
// 为测试用例添加事务，SpringBoot会对测试用例对应的事务提交操作进行回滚
@Transactional
//如果想在测试用例中提交事务，可以通过@Rollback注解设置回滚状态为false即可正常提交事务
@Rollback(false)
public class DAOTest {

    @Autowired
    private BookService bookService;

    @Test
    void testSave() {
        Book book = new Book();
        book.setName("springboot");
        book.setType("springboot");
        book.setDescription("springboot");

        bookService.save(book);
    }
}
