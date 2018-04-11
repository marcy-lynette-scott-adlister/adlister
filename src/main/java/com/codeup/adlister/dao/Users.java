package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    User findByEmail(String email);
    void updateUser(User user);
    void updateUserPassword(User user);
    void deleteUser(Long id);
}
