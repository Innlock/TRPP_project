package com.example.demo.controller;

import com.example.demo.bookService.BookService;
import com.example.demo.model.Book;
import com.example.demo.model.User;
import com.example.demo.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/books")
    public Book create(@RequestBody Book book) {
        return bookService.add(book);
    }

    @GetMapping("/books")
    public Iterable<Book> getAll() {
        return bookService.getAll();
    }
}
