package com.okten.JavaAdvanced.service;

import com.okten.JavaAdvanced.dto.UserDTO;
import com.okten.JavaAdvanced.entity.User;

import java.util.List;

public interface IUserService {


    List<User> getAllUsers();
    UserDTO addUser(User user, int carId);
    User updateUser(User user);
    void deleteUser(int id);
    User getById(int id);
}
