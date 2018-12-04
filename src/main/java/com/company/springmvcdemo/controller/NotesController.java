package com.company.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotesController {
    @GetMapping("/notes")
    public String getNotes(){
        System.out.println("redirection works");
        return "notes";
    }
}
