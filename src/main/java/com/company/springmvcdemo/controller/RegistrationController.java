package com.company.springmvcdemo.controller;

import com.company.springmvcdemo.dto.RegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @GetMapping("/registration")
    public String greeting(Model model) {
        model.addAttribute("registrationDTO", new RegistrationDTO());

        return "registration";
    }

    @PostMapping("/registration")
    public String catFormSubmit(@ModelAttribute RegistrationDTO registrationDTO) {
        System.out.println(registrationDTO);
        return "registration";
    }
}

