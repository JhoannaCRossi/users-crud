package com.crud.users.dao;

import com.crud.users.models.User;

import java.util.List;

public interface IUserDAO {
    List<User> getUsers();
}
