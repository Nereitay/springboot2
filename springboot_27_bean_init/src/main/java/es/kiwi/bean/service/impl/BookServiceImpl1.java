package es.kiwi.bean.service.impl;

import es.kiwi.bean.service.BookService;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl1 implements BookService {
    @Override
    public void check() {
        System.out.println("book service 1..");
    }
}
