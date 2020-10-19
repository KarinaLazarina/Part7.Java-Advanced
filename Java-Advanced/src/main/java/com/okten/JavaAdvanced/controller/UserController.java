package com.okten.JavaAdvanced.controller;

import com.okten.JavaAdvanced.dao.UserDao;
import com.okten.JavaAdvanced.dto.UserDTO;
import com.okten.JavaAdvanced.entity.User;
import com.okten.JavaAdvanced.service.IUserService;
import com.okten.JavaAdvanced.service.UserService;
import com.okten.JavaAdvanced.validator.PasswordValidator;
import com.okten.JavaAdvanced.validator.UniqueUserEmailValidator;
import com.okten.JavaAdvanced.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    //private UserDao userDao;
    private IUserService userService;
    private UserValidator userValidator;
    private UniqueUserEmailValidator uniqueUserEmailValidator;
    private PasswordValidator passwordValidator;

    @Autowired
    public UserController(IUserService userService, UserValidator userValidator, UniqueUserEmailValidator uniqueUserEmailValidator, PasswordValidator passwordValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.uniqueUserEmailValidator = uniqueUserEmailValidator;
        this.passwordValidator = passwordValidator;
    }

    @GetMapping
    public List<User> getUsers()
    {
        return userService.getAllUsers();
    }

    @PostMapping(value = {"/cars/{carId}"})
    private UserDTO addUser(@RequestBody @Valid User user, @PathVariable int carId){

        return userService.addUser(user,carId);
    }

    @PutMapping(value = "/{id}")
    private User updateUser(@PathVariable int id, @RequestBody User user){
        user.setId(id);
        return userService.updateUser(user);
    }
//    @PatchMapping(value = "/{id}")
//    private User update2User(@PathVariable int id, @RequestBody String name){
//        User user = userDao.getOne(id);
//        user.setName(name);
//        userDao.save(user);
//        return user;
//    }

    @DeleteMapping(value = "/{id}")
    private void deleteUser(@PathVariable int id){
        userService.deleteUser(id);

    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder ){
        webDataBinder.addValidators(userValidator, uniqueUserEmailValidator, passwordValidator);
    }

}
