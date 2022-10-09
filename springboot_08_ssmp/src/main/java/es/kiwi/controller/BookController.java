package es.kiwi.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import es.kiwi.model.Book;
import es.kiwi.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books2")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.list();
    }

    /*
    * @requestBody注解常用来处理content-type不是默认的application/x-www-form-urlcoded编码的内容，
    * 比如说：application/json或者是application/xml等。
    * 一般情况下来说常用其来处理application/json类型。
    *
    * */
    @PostMapping
    public Boolean save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping
    public Boolean update(@RequestBody Book book) {
        return bookService.modify(book);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id) {
        return bookService.delete(id);
    }

    @GetMapping("{id}")
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @GetMapping("/{current}/{size}")
    public IPage getPage(@PathVariable int current, @PathVariable int size) {
        return bookService.getPage(current, size);
    }

}
