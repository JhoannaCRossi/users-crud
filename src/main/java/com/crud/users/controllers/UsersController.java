package com.crud.users.controllers;

import com.crud.users.dao.IUserDAO;
import com.crud.users.models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersController {
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
        List<User> users = new ArrayList<>();

        User user = new User();
        user.setId(1L);
        user.setName("jhoa");
        user.setLastName("rossi");
        user.setEmail("rossi@com.ar");
        user.setPhone("555-55-555");

        User user2 = new User();
        user2.setId(2L);
        user2.setName("nany");
        user2.setLastName("rossi");
        user2.setEmail("rossi2@com.ar");
        user2.setPhone("777-77-777");

        users.add(user);
        users.add(user2);
        return users;
    }
}
