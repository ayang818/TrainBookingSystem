package com.ayang818.trainbooking.service.impl;

import com.ayang818.trainbooking.dto.LoginfoDto;
import com.ayang818.trainbooking.dto.RegisterInfoDto;
import com.ayang818.trainbooking.mapper.AuthenticationMapper;
import com.ayang818.trainbooking.model.User;
import com.ayang818.trainbooking.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AuthenticationServiceImpl
 * @Description 登陆授权认证业务逻辑封装
 * @Author 杨丰畅
 * @Date 2019/12/3 23:28
 **/
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

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
            LOGGER.info("用户名 {} 已存在", registerInfoDto.getUsername());
            return false;
        }
        return true;
    }
}
