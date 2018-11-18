package com.company.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CatFormController {
    @GetMapping("/catForm")
    public String getCatFormPage(Model model){
        model.addAttribute("cat", new Cat());
        return "catForm";
    }

    @PostMapping("/catForm")
    public String catFormSubmit(@ModelAttribute Cat cat) {
        System.out.println(cat);
        return "catForm";
    }
}
