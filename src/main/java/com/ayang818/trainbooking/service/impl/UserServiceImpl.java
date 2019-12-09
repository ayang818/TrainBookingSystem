package com.ayang818.trainbooking.service.impl;

import com.ayang818.trainbooking.mapper.UserMapper;
import com.ayang818.trainbooking.model.User;
import com.ayang818.trainbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc 用户操作业务逻辑封装
 * @author 杨丰畅
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.list();
    }
}
