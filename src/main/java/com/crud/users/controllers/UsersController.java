package com.crud.users.controllers;

import com.crud.users.dao.IUserDAO;
import com.crud.users.dao.UserDAOImp;
import com.crud.users.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private IUserDAO iUserDAO;
    @RequestMapping(value= "user/{id}")
    public User getUser(@PathVariable Long id){
        User user = new User();
        user.setId(id);
        user.setName("jhoa");
        user.setLastName("rossi");
        user.setEmail("rossi@com.ar");
        user.setPhone("555-55-555");
        return user;
    }

    @RequestMapping(value= "users")
    public List<User> getUsers(){
        return iUserDAO.getUsers();
    }
}
