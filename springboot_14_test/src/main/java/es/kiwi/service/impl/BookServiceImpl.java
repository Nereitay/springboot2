package es.kiwi.service.impl;

import es.kiwi.mapper.BookDAO;
import es.kiwi.model.Book;
import es.kiwi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public boolean save(Book book) {
        return bookDAO.insert(book) > 0;
    }
}
