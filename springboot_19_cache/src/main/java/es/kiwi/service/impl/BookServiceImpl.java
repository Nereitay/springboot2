package es.kiwi.service.impl;

import es.kiwi.mapper.BookDAO;
import es.kiwi.model.Book;
import es.kiwi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;
    /**
     * 模拟缓存
     */
//    private HashMap<Integer, Book> cache = new HashMap<>();

    @Override
    public Boolean save(Book book) {
        return bookDAO.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDAO.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDAO.deleteById(id) > 0;
    }

    @Override
    @Cacheable(value = "cacheSpace", key = "#id")
    public Book getById(Integer id) {
        return bookDAO.selectById(id);
    }

    /*@Override
    public Book getById(Integer id) {
        //如果当前缓存中没有本次要查询的数据，则进行查询，否则直接从缓存中获取数据返回
        Book book = cache.get(id);
        if(Objects.isNull(book)) {
            Book queryBook = bookDAO.selectById(id);
            cache.put(id, queryBook);
            return queryBook;
        }
        return book;
    }*/

    @Override
    public List<Book> getAll() {
        return bookDAO.selectList(null);
    }


}
