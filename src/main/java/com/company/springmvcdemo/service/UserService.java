package com.company.springmvcdemo.service;

import com.company.springmvcdemo.dao.UserDao;
import com.company.springmvcdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findUserByLoginAndPassword(String login, String password) {
        return userDao.findUserByLoginAndPassword(login, password);
    }

    public User findUserByLogin(String login){
        return userDao.findUserByLogin(login);
    }


    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }


    public void createUser(User user) {
        userDao.createUser(user);
    }
}
