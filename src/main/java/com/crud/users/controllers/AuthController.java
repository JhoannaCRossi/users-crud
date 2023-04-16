package com.crud.users.controllers;

import com.crud.users.dao.IUserDAO;
import com.crud.users.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class AuthController {
    @Autowired
    private IUserDAO iUserDAO;
    @RequestMapping(value= "api/login", method= RequestMethod.POST)
    public String login(@RequestBody User user){
       if(iUserDAO.checkUser(user)){
           return "ok";
       }
           return "fail";
    }
}
