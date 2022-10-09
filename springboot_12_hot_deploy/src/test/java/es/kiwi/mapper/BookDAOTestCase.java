package es.kiwi.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import es.kiwi.model.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDAOTestCase {


    @Autowired
    private BookDAO bookDAO;


    @Test
    public void testGetById() {
        System.out.println(bookDAO.selectById(1));
    }

    @Test
    public void testSave() {
        Book book = new Book();

        book.setType("测试");
        book.setName("测试123");
        book.setDescription("测试数据123");

        bookDAO.insert(book);

    }

    @Test
    public void testUpdate() {
        Book book = new Book();

        book.setId(13);
        book.setType("测试");
        book.setName("测试123");
        book.setDescription("测试数据abc");

        bookDAO.updateById(book);
    }

    @Test
    public void testDelete() {
        bookDAO.deleteById(13);
    }

    @Test
    public void testGetAll() {
        bookDAO.selectList(null);
    }

    /*
    * 使用IPage封装分页数据
    * 分页操作依赖MyBatisPlus分页拦截器实现功能
    * 借助MyBatisPlus日志查阅执行SQL语句
    *
    * */
    @Test
    public void testGetPage() {

        IPage page = new Page(2, 6);

        bookDAO.selectPage(page, null);

        /*
        * IPage对象中封装了分页操作中的所有数据
        * 数据
        * 当前页码值
        * 每页数据总量
        * 最大页码值
        * 数据总量
        *
        * */
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
    }

    @Test
    public void testGetBy() {
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "Spring");
        bookDAO.selectList(qw);
    }

    @Test
    public void testGetBy2() {
        String name = "Spring";
        String name1 = null;
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
//        if (name != null) lqw.like(Book::getName, name);
        lqw.like(Strings.isNotEmpty(name1), Book::getName, name1);
        bookDAO.selectList(lqw);
    }
}
