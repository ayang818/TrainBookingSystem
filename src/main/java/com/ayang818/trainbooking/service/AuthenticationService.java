package com.ayang818.trainbooking.service;

import com.ayang818.trainbooking.dto.LoginfoDto;
import com.ayang818.trainbooking.dto.RegisterInfoDto;
import com.ayang818.trainbooking.model.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    User tryLogin(LoginfoDto loginfoDto);
    Boolean tryRegister(RegisterInfoDto registerInfoDto);
}