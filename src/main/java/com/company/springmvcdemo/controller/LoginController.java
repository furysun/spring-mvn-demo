package com.company.springmvcdemo.controller;

import com.company.springmvcdemo.domain.Role;
import com.company.springmvcdemo.domain.User;
import com.company.springmvcdemo.dto.LoginDTO;
import com.company.springmvcdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginDTO", new LoginDTO());

        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO, Model model) {
        User user = userService.findUserByLoginAndPassword(loginDTO.getLogin(), loginDTO.getPassword());

        if (user == null) {
            model.addAttribute("error", true);
            return "login";
        }

        if (user.getRole() == Role.USER) {
            return "notes";
        } else return "users";
    }
}
