package com.bookshelf.controller;


import com.bookshelf.model.User;
import com.bookshelf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String create_user(@RequestParam String username,
                            @RequestParam String password,
                            @RequestParam String email,
                            @RequestParam String telephone,
                            Map<String, Object> model) {
        if(username=="" || password=="" || (email.isEmpty() && telephone.isEmpty())){
            model.put("message", "Не вся информация заполнена");
            return "registration";
        }
        if (telephone.isEmpty()){
            telephone="0";
        }
        User user = new User(username, password, email, Long.parseLong(telephone));
        Optional userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb.isPresent()) {
            model.put("message", "Пользователь с таким именем уже есть");
            return "registration";
        }
        userRepository.save(user);
        return "redirect:/login";
    }
}
