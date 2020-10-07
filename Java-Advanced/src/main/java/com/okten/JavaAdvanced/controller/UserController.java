package com.okten.JavaAdvanced.controller;

import com.okten.JavaAdvanced.dao.UserDao;
import com.okten.JavaAdvanced.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @PutMapping(value = "/{id}")
    private User updateUser(@PathVariable int id, @RequestBody User user){
        user.setId(id);
        userDao.save(user);
        return user;
    }
    @PatchMapping(value = "/{id}")
    private User update2User(@PathVariable int id, @RequestBody String name){
        User user = userDao.getOne(id);
        user.setName(name);
        userDao.save(user);
        return user;
    }

    @DeleteMapping(value = "/{id}")
    private void deleteUser(@PathVariable int id){
        userDao.deleteById(id);

    }

}
