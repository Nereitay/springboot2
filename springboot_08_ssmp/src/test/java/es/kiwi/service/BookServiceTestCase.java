package es.kiwi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import es.kiwi.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private BookService bookService;

    @Test
    public void testGetById() {
        System.out.println(bookService.getById(4));
    }

    @Test
    public void testSave() {
        Book book = new Book();

        book.setType("测试");
        book.setName("测试123");
        book.setDescription("测试数据123");

        bookService.save(book);

    }

    @Test
    public void testUpdate() {
        Book book = new Book();

        book.setId(14);
        book.setType("测试");
        book.setName("测试123");
        book.setDescription("测试数据abc");

        bookService.update(book);
    }

    @Test
    public void testDelete() {
        bookService.delete(14);
    }

    @Test
    public void testGetAll() {
        bookService.getAll();
    }


    @Test
    public void testGetPage() {

        IPage page = bookService.getPage(2, 3);

        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
    }
}
