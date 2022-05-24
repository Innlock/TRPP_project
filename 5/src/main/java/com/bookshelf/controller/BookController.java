package com.bookshelf.controller;
import com.bookshelf.model.Book;
import com.bookshelf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * BookController - request handler for books
 */
//@RestController
@Controller
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
    public String getBooks(@PathVariable(required = false) Long id, Model model){
        if (id != null) {
            List<Book> books = new ArrayList<>();
            books.add(bookRepository.findById(id).orElse(null));
            model.addAttribute("books", books);
            return "book";
        }
        //return (List<Book>) bookRepository.findAll();
        Iterable<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "books";
    }
}
