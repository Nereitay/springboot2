package es.kiwi.service.impl;

import com.alicp.jetcache.anno.*;
import es.kiwi.mapper.BookDAO;
import es.kiwi.model.Book;
import es.kiwi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public Boolean save(Book book) {
        return bookDAO.insert(book) > 0;
    }

    @Override
    @CacheUpdate(name = "book_", key = "#book.id", value = "#book")
    public Boolean update(Book book) {
        return bookDAO.updateById(book) > 0;
    }

    @Override
    @CacheInvalidate(name = "book_", key = "#id")
    public Boolean delete(Integer id) {
        return bookDAO.deleteById(id) > 0;
    }

    @Override
    @Cached(name = "book_", key = "#id", expire = 3600, cacheType = CacheType.REMOTE)
//    @CacheRefresh(refresh = 10) //如果设置时间短，会不停地查询数据库
    public Book getById(Integer id) {
        return bookDAO.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDAO.selectList(null);
    }


}
