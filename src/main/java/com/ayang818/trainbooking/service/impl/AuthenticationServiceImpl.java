package com.ayang818.trainbooking.service.impl;

import com.ayang818.trainbooking.dto.LoginfoDto;
import com.ayang818.trainbooking.dto.RegisterInfoDto;
import com.ayang818.trainbooking.mapper.AuthenticationMapper;
import com.ayang818.trainbooking.model.User;
import com.ayang818.trainbooking.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AuthenticationServiceImpl
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/12/3 23:28
 **/
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private AuthenticationMapper authenticationMapper;

    @Override
    public User tryLogin(LoginfoDto loginfoDto) {
        List<User> users = authenticationMapper.listOne(loginfoDto);
        if (users.size() == 0) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public Boolean tryRegister(RegisterInfoDto registerInfoDto) {
        try {
            authenticationMapper.insertUser(registerInfoDto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
