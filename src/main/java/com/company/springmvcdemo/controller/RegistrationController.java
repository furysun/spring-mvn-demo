package com.company.springmvcdemo.controller;

import com.company.springmvcdemo.domain.User;
import com.company.springmvcdemo.dto.RegistrationDTO;
import com.company.springmvcdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String getRegistration(Model model) {
        model.addAttribute("registrationDTO", new RegistrationDTO());

        return "registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute RegistrationDTO registrationDTO, Model model) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getPasswordConfirmation())) {
            model.addAttribute("error", true);
            return "registration";
        }

        User existentUser = userService.findUserByLogin(registrationDTO.getLogin());

        if(existentUser!=null){
            model.addAttribute("suchLoginIsBusy", true);
            return "registration";
        }

        User user = new User();

        user.setName(registrationDTO.getName());
        user.setLogin(registrationDTO.getLogin());
        user.setPassword(registrationDTO.getPassword());

        userService.createUser(user);

        return "registration";
    }
}

