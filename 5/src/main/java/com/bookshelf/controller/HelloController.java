package com.bookshelf.controller;

import com.bookshelf.model.Advert;
import com.bookshelf.model.Book;
import com.bookshelf.repository.AdvertRepository;
import com.bookshelf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * HelloController - a simple controller for studying the concept of mapping
 */
@Controller
public class HelloController {

    @Autowired
    private AdvertRepository advertRepository;
    @Autowired
    private UserRepository userRepository;

    /**
     * get request for /hello will return Hello!
     *
     * @return "Hello!" string
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello!";
    }

    @GetMapping("/genre/{genre}")
    public String genre(@RequestParam(required = false) String genre, Model model) {
        Iterable<Advert> adverts = advertRepository.findAll();
        model.addAttribute("adverts", adverts);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ((!(auth instanceof AnonymousAuthenticationToken)) && auth != null) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();

            if (userDetail != null) {
                model.addAttribute("username", userDetail.getUsername());
            } else {
                model.addAttribute("username", "");
            }
        }
        model.addAttribute("genre", genre);
        return "genre";
    }

    @GetMapping("/")
    public String greeting(@RequestParam(required = false) String genre, Model model) {
        Iterable<Advert> adverts = advertRepository.findAll();
        model.addAttribute("adverts", adverts);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ((!(auth instanceof AnonymousAuthenticationToken)) && auth != null) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();

            if (userDetail != null) {
                model.addAttribute("username", userDetail.getUsername());
            } else {
                model.addAttribute("username", "");
            }
        }
        return "greeting";
    }

    }
