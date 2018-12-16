package com.company.springmvcdemo.controller;

import com.company.springmvcdemo.domain.User;
import com.company.springmvcdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/createUser")
    public String getCreateUserPage(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/user")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @PostMapping("/editUser")
    public String editUser(@ModelAttribute User user) {
        System.out.println(user);
        userService.updateUser(user);
        return "redirect:/users";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam String id) {
        System.out.println("delete" + id);

        userService.deleteUser(id);

        return "redirect:/users";
    }

    @PostMapping("/editUserPage")
    public String editUser(@RequestParam String id, Model model) {

        User user = userService.findById(id);
        System.out.println(user);
        model.addAttribute("user", user);
        model.addAttribute("isEdit",true);
        return "createUser";
    }
}
