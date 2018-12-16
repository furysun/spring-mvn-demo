package com.company.springmvcdemo.dao;

import com.company.springmvcdemo.domain.Role;
import com.company.springmvcdemo.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("ID"));
        user.setLogin(resultSet.getString("LOGIN"));
        user.setName(resultSet.getString("NAME"));
        user.setPassword(resultSet.getString("PASSWORD"));
        user.setRole(Role.valueOf(resultSet.getString("ROLE")));

        return user;
    }
}
