package es.kiwi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import es.kiwi.model.Book;

public interface IBookService extends IService<Book> {

    boolean saveBook(Book book);

    boolean modify(Book book);

    boolean delete(Integer id);

    IPage<Book> getPage(int currentPage, int pageSize);

    IPage<Book> getPage(int current, int size, Book book);
}
