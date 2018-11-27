package com.company.springmvcdemo.dto;

public class LoginDTO {

    private String login;
    private String password;


    public LoginDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public LoginDTO() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
