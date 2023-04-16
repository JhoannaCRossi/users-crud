package com.crud.users.controllers;

import com.crud.users.dao.IUserDAO;
import com.crud.users.dao.UserDAOImp;
import com.crud.users.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private IUserDAO iUserDAO;
    @RequestMapping(value= "api/users/{id}")
    public User getUser(@PathVariable Long id){
        User user = new User();
        user.setId(id);
        user.setName("jhoa");
        user.setLastName("rossi");
        user.setEmail("rossi@com.ar");
        user.setPhone("555-55-555");
        return user;
    }

    @RequestMapping(value= "api/users", method= RequestMethod.GET)
    public List<User> getUsers(){
        return iUserDAO.getUsers();
    }
    @RequestMapping(value= "api/users/{id}", method= RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        iUserDAO.deleteUser(id);
    }

    @RequestMapping(value= "api/users", method= RequestMethod.POST)
    public void registerUser(@RequestBody User user){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1,user.getPassword());
        user.setPassword(hash);
        iUserDAO.registerUser(user);
    }
}
