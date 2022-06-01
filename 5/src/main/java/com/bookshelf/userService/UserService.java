package com.bookshelf.userService;

import com.bookshelf.model.User;

public interface UserService {
    User add(User user);
    Iterable<User> getAll();
    User getCurrentUser();
}
