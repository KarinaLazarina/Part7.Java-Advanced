package com.okten.JavaAdvanced.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {


    private int userId;
    private String name;
    private int age;
    private int carId;

}
