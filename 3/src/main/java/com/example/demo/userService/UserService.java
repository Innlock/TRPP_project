package com.example.demo.userService;

import com.example.demo.model.User;

public interface UserService {
    User add(User user);
    Iterable<User> getAll();
}
