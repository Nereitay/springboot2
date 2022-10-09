package es.kiwi.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import es.kiwi.mapper.BookDAO;
import es.kiwi.model.Book;
import es.kiwi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Boolean update(Book book) {
        return bookDAO.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDAO.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDAO.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDAO.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {

        return bookDAO.selectPage(new Page(currentPage, pageSize), null);
    }
}
