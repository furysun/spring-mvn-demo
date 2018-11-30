package com.company.springmvcdemo.controller;

import com.company.springmvcdemo.domain.User;
import com.company.springmvcdemo.dto.LoginDTO;
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
    private final String FIND_USER_BY_LOGIN_AND_PASSWORD = "select * from USERS where LOGIN =? and PASSWORD =?;";


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginDTO", new LoginDTO());

        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO, Model model) {
        User user = findUserByLoginAndPassword(loginDTO.getLogin(), loginDTO.getPassword());
        if(user==null){
           model.addAttribute("error",true);
           return "login";
        }

        return "users";
    }

    private User findUserByLoginAndPassword(String login, String password) {
        try {
            return (User) jdbcTemplate.queryForObject(
                    FIND_USER_BY_LOGIN_AND_PASSWORD,
                    new Object[]{login, password},
                    new UserRowMapper()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
