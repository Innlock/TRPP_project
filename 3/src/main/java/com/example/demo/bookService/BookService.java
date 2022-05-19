package com.example.demo.bookService;

import com.example.demo.model.Book;

public interface BookService {
    Book add(Book book);
    Iterable<Book> getAll();
}
