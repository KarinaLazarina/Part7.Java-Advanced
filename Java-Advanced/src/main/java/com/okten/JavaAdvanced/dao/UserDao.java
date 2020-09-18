package com.okten.JavaAdvanced.dao;

import com.okten.JavaAdvanced.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
