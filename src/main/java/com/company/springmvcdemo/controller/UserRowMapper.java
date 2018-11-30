package com.company.springmvcdemo.controller;

import com.company.springmvcdemo.domain.Role;
import com.company.springmvcdemo.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User user1 = new User();
        user1.setId(resultSet.getInt("ID"));
        user1.setLogin(resultSet.getString("LOGIN"));
        user1.setName(resultSet.getString("NAME"));
        user1.setPassword(resultSet.getString("PASSWORD"));
        user1.setRole(Role.valueOf(resultSet.getString("ROLE")));

        return user1;
    }
}
