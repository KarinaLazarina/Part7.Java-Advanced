package com.okten.JavaAdvanced.service;

import com.okten.JavaAdvanced.entity.Car;

import java.util.List;

public interface ICarService {
    List<Car> getAllCars();
    Car getCarById(int id);
    Car saveCar(Car car);
    void deleteCar(int id);
}
