package com.sda.kino.db.repository;

import com.sda.kino.db.model.User;
import org.springframework.stereotype.Repository;

public interface UserRepository {
    boolean isLoginExists(String login);

    void save(User user);
}
