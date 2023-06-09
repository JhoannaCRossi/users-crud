package com.crud.users.dao;

import com.crud.users.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IUserDAO {
    @Autowired
    List<User> getUsers();

    void deleteUser(Long id);

    void registerUser(User user);

    User checkUser(User user);
}
