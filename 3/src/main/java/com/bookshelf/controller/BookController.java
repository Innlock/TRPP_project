package com.bookshelf.controller;
import com.bookshelf.model.Book;
import com.bookshelf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * BookController - request handler for books
 */
@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    /**
     * Post request will extract all the info from json and create an entity class out of it.
     * @param book (json)
     * @return book json (if it was successfully saved)
     */
    @PostMapping("/books")
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    /**
     * Get request will convert class entity to json and return it (of id is specified) or them.
     * @param id id specified in the link
     * @return book (with the specified id) or books (json)
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
