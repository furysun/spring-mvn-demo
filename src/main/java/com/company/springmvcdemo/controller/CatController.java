package com.company.springmvcdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CatController {
    @GetMapping("/cat")
    public String cat(Model model) {
        // 1. primitives
        model.addAttribute("name", "tom");
        model.addAttribute("int", 2);

        // 2. object
        Cat cat = new Cat("mr",2);

        model.addAttribute("cat", cat);

        // 3. collection
        List<Cat> cats = new ArrayList<>();
        Cat cat2 = new Cat("mila",5);
        Cat cat3 = new Cat("hi",3);
        Cat cat4 = new Cat("rio",6);

        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);

        model.addAttribute("catsList",cats);

        return "cat-page";
    }
}

class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
