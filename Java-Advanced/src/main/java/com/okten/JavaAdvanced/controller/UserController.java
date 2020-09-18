package com.okten.JavaAdvanced.controller;

import com.okten.JavaAdvanced.dao.UserDao;
import com.okten.JavaAdvanced.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public List<User> getUsers(){
        return userDao.findAll();
    }

    @PostMapping
    private User addUser(@RequestBody User user){
        userDao.save(user);
        return user;
    }
}
