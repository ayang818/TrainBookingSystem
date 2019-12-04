package com.ayang818.trainbooking.dto;

import lombok.Data;

@Data
public class RegisterInfoDto {
    private String username;
    private String password;
    private String email;
    private Integer type;
}
