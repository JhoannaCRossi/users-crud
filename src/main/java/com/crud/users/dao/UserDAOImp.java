package com.crud.users.dao;

import com.crud.users.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class UserDAOImp implements IUserDAO {
    @Override
    public List<User> getUsers() {
        return null;
    }
}
