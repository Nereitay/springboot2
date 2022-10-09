package es.kiwi.mapper.impl;

import es.kiwi.mapper.BookDAO;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOImpl implements BookDAO {
    @Override
    public void save() {
        System.out.println("book dao is running...");
    }
}
