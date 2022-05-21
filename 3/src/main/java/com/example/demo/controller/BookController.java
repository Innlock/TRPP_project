package com.example.demo.controller;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Метод create типа post, принимает json книги и сохраняет её в бд
     * @param book
     * @return
     */
    @PostMapping("/books")
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    /**
     * Метод getBooks типа get, возвращает либо все книги, либо книгу по id
     * в формате json
     * @param id
     * @return
     */
    @GetMapping(value = {"/books", "/books/{id}"})
    public List<Book> getBooks(@PathVariable(required = false) Long id){
        if (id != null) {
            List<Book> books = new ArrayList<>();
            books.add(bookRepository.findById(id).orElse(null));
            return books;
        }
        return (List<Book>) bookRepository.findAll();
    }
}
