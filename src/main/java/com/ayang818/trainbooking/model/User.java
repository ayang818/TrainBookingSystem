package com.ayang818.trainbooking.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
}
