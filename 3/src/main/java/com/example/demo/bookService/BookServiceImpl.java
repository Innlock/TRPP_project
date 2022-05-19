package com.example.demo.bookService;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book add(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Iterable<Book> getAll() {
        return bookRepository.findAll();
    }
}