package com.okten.JavaAdvanced.dao;

import com.okten.JavaAdvanced.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDAO extends JpaRepository<Car, Integer> {
}
