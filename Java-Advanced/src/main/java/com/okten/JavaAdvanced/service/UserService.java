package com.okten.JavaAdvanced.service;

import com.okten.JavaAdvanced.dao.CarDAO;
import com.okten.JavaAdvanced.dao.UserDao;
import com.okten.JavaAdvanced.dto.UserDTO;
import com.okten.JavaAdvanced.entity.Car;
import com.okten.JavaAdvanced.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserDao userDao;
    private CarDAO carDAO;

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public UserDTO addUser(User user, int carId) {
        System.out.println(user);
        System.out.println(carId);
        //user.setCar(carDAO.getOne(carId));
        userDao.save(user);
        return new UserDTO(user.getId(),user.getName(),user.getAge(), carId);
        //return  null;
//        final Optional<Car> optionalCar = carDAO.findById(carId);
//        Car car = optionalCar.get();
//        System.out.println(car);
//        user.setCar(car);
//        user = userDao.save(user);
//
//        return new UserDTO(user.getId(),user.getName(),user.getAge(), car.getModel());
    }

    @Override
    public User updateUser(User user) {
        return userDao.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteById(id);
    }

    @Override
    public User getById(int id) {
        return userDao.findById(id).orElseThrow(() -> new RuntimeException("No user with id: " + id));
    }
}
