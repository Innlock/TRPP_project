package com.bookshelf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController - a simple controller for studying the concept of mapping
 */
@RestController
public class HelloController {

    /**
     * get request for /hello will return Hello!
     * @return "Hello!" string
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello!";
    }

}
