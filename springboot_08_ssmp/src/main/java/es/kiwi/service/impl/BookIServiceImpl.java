package es.kiwi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import es.kiwi.mapper.BookDAO;
import es.kiwi.model.Book;
import es.kiwi.service.IBookService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookIServiceImpl extends ServiceImpl<BookDAO, Book> implements IBookService {

    @Autowired
    private BookDAO bookDAO;

    private Counter counter;

    /**
     * 自定义Metrics - Admin
     * @param meterRegistry
     */
    public BookIServiceImpl(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("用户付费操作次数");
    }

    @Override
    public boolean saveBook(Book book) {
        return bookDAO.insert(book) > 0;
    }

    @Override
    public boolean modify(Book book) {
        return bookDAO.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        //每次执行删除业务等同于执行了付费业务
        counter.increment();
        return bookDAO.deleteById(id) > 0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page(currentPage, pageSize);
        bookDAO.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Book> getPage(int current, int size, Book book) {

        LambdaQueryWrapper<Book> lqw  = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());

        IPage<Book> page = new Page(current, size);
        bookDAO.selectPage(page, lqw);
        return page;
    }
}
