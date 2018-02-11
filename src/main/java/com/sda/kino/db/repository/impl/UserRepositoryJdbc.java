package com.sda.kino.db.repository.impl;

import com.sda.kino.db.model.User;
import com.sda.kino.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepositoryJdbc")
public class UserRepositoryJdbc implements UserRepository {

    private static final String INSERT_SQL = "INSERT INTO users(login, password, email) VALUES ('%s', '%s', '%s')";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean isLoginExists(String login) {
        List<String> result = jdbcTemplate.queryForList("SELECT login FROM users WHERE login=?", new Object[]{login}, String.class);
        return !result.isEmpty();
    }

    @Override
    public void save(User user) {
        jdbcTemplate.execute(String.format(INSERT_SQL, user.getLogin(), user.getPassword(), user.getEmail()));
    }
}
