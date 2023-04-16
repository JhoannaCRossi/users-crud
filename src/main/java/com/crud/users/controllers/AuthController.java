package com.crud.users.controllers;

import com.crud.users.dao.IUserDAO;
import com.crud.users.models.User;
import com.crud.users.utils.JWTUtil;
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

    @Autowired
    private JWTUtil jwtUtil;
    @RequestMapping(value= "api/login", method= RequestMethod.POST)
    public String login(@RequestBody User user){
        User userCheck = iUserDAO.checkUser(user);
        if(userCheck != null){
            String token = jwtUtil.create(String.valueOf(userCheck.getId()), userCheck.getEmail());
            return token;
        }
        return "fail";
    }
}
