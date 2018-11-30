package com.company.springmvcdemo.controller;

import com.company.springmvcdemo.dto.RegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/registration")
    public String getRegistration(Model model) {
        model.addAttribute("registrationDTO", new RegistrationDTO());

        return "registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute RegistrationDTO registrationDTO) {
            System.out.println(registrationDTO);
        jdbcTemplate.execute("select * from USERS");
        return "registration";
    }
}

