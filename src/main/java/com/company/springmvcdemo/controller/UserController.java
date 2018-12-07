package com.company.springmvcdemo.controller;

import com.company.springmvcdemo.domain.User;
import com.company.springmvcdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public String getNotes(Model model) {
        System.out.println("redirection users works");
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        System.out.println("work?"+users);
        return "users";

    }
}
