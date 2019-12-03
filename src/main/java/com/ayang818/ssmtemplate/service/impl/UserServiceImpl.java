package com.ayang818.ssmtemplate.service.impl;

import com.ayang818.ssmtemplate.mapper.UserMapper;
import com.ayang818.ssmtemplate.model.User;
import com.ayang818.ssmtemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.list();
    }
}
