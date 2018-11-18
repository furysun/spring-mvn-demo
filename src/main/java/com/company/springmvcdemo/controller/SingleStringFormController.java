package com.company.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SingleStringFormController {
    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("result","initial");

        return "singleStringForm";
    }

    @PostMapping("/form")
    public String catchFromForm(@RequestParam String text, Model model){
        model.addAttribute("result",text);

        return "singleStringForm";
    }
}
