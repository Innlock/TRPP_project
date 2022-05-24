package com.bookshelf.controller;

import com.bookshelf.model.Greeting;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HelloController - a simple controller for studying the concept of mapping
 */
@Controller
public class HelloController {

    /**
     * get request for /hello will return Hello!
     *
     * @return "Hello!" string
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello!";
    }

    @GetMapping("/")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "добро пожаловать") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

//    @RequestMapping(value="/greeting", method=RequestMethod.POST)
//    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
//        model.addAttribute("greeting", greeting);
//        return "result";
//    }
}
