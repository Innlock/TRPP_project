package com.bookshelf.controller;

import com.bookshelf.model.Advert;
import com.bookshelf.model.Book;
import com.bookshelf.model.User;
import com.bookshelf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * UserController - request handler for users
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Post request will extract all the info from json and create an entity class out of it.
     *
     * @param user (json)
     * @return user json (if it was successfully saved)
     */
    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    /**
     * Get request will convert class entity to json and return it (of id is specified) or them.
     *
     * @param id id specified in the link
     * @return user (with the specified id) or users (json)
     */
    @GetMapping(value = {"/users", "/users/{id}"} )
    public List<User> getAdvert(@PathVariable(required = false) Long id) {
        if (id != null) {
            List<User> users = new ArrayList<>();
            users.add(userRepository.findById(id).orElse(null));
            return users;
        }
        return (List<User>) userRepository.findAll();
    }
}
