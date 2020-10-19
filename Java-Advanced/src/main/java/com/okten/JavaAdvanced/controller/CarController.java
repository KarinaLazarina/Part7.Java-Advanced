package com.okten.JavaAdvanced.controller;

import com.okten.JavaAdvanced.entity.Car;
import com.okten.JavaAdvanced.service.ICarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private ICarService carService;

    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getCars(){
        return carService.getAllCars();
    }

    @PostMapping
    private Car addCar(@RequestBody Car car){
        return carService.saveCar(car);
    }
}
