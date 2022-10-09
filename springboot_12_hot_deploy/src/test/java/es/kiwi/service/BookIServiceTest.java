package es.kiwi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import es.kiwi.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookIServiceTest {

    @Autowired
    private IBookService bookIService;

    @Test
    public void testGetById() {
        System.out.println(bookIService.getById(4));
    }

    @Test
    public void testSave() {
        Book book = new Book();

        book.setType("测试");
        book.setName("测试123");
        book.setDescription("测试数据123");

        bookIService.save(book);

    }

    @Test
    public void testUpdate() {
        Book book = new Book();

        book.setId(14);
        book.setType("测试");
        book.setName("测试123");
        book.setDescription("测试数据abc");

        bookIService.updateById(book);
    }

    @Test
    public void testDelete() {
        bookIService.removeById(14);
    }

    @Test
    public void testGetAll() {
        bookIService.list();
    }


    @Test
    public void testGetPage() {

        IPage page = new Page(2, 3);
        bookIService.page(page);

        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
    }
}
