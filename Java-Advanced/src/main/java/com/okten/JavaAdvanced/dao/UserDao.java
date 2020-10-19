package com.okten.JavaAdvanced.dao;

import com.okten.JavaAdvanced.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User, Integer> {

    //User findByEmail(String email);
    boolean existsByEmail(String email);

}
