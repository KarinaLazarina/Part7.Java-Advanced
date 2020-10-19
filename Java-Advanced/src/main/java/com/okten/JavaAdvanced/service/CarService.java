package com.okten.JavaAdvanced.service;

import com.okten.JavaAdvanced.dao.CarDAO;
import com.okten.JavaAdvanced.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService{

    private CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public List<Car> getAllCars() {
        return carDAO.findAll();
    }

    @Override
    public Car getCarById(int id) {
        return carDAO.getOne(id);
    }

    @Override
    public Car saveCar(Car car) {
        return carDAO.save(car);
    }

    @Override
    public void deleteCar(int id) {
        carDAO.deleteById(id);
    }
}
