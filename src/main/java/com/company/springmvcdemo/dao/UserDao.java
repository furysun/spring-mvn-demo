package com.company.springmvcdemo.dao;

import com.company.springmvcdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {
    private static final String FIND_USER_BY_LOGIN_AND_PASSWORD = "select * from USERS where LOGIN =? and PASSWORD =?;";
    private static final String FIND_USER_BY_LOGIN = "select * from USERS where LOGIN =?;";
    private static final String CREATE_USER = "INSERT INTO USERS (NAME, LOGIN, PASSWORD, ROLE) VALUES (?, ?, ?, 'USER');";
    private static final String FIND_ALL_USERS = "select * from USERS;";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findUserByLoginAndPassword(String login, String password) {
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

    public List<User> getAllUsers() {
        try {
            return jdbcTemplate.query(
                    FIND_ALL_USERS,
                    new UserRowMapper()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public User findUserByLogin(String login) {
        try {
            return (User) jdbcTemplate.queryForObject(
                    FIND_USER_BY_LOGIN,
                    new Object[]{login},
                    new UserRowMapper()
            );
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void createUser(User user) {
        jdbcTemplate.update(CREATE_USER, user.getName(), user.getLogin(), user.getPassword());
    }
}
