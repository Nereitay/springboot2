package es.kiwi.controller;

import es.kiwi.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {

    @GetMapping
    public String get() {
        System.out.println("get is running...");
        return "springboot";
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id) {
        System.out.println("getById is running...");

        Book book = new Book();
        book.setId(id);
        book.setName("springboot");
        book.setType("springboot");
        book.setDescription("springboot");

        return book;
    }
}
