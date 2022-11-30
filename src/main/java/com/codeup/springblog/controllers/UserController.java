package com.codeup.springblog.controllers;

import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserRepository userDao;

    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, UserRepository userDao1, PasswordEncoder passwordEncoder){
        this.userDao = userDao1;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/register")
    public String showRegistration(Model model){
        model.addAttribute("user", new User());
        return "/registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
        return "redirect:/post/index";
    }



}

