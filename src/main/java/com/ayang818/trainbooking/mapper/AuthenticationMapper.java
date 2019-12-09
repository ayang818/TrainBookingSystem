package com.ayang818.trainbooking.mapper;

import com.ayang818.trainbooking.dto.LoginfoDto;
import com.ayang818.trainbooking.dto.RegisterInfoDto;
import com.ayang818.trainbooking.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @desc 登陆注册数据库操作
 * @author 杨丰畅
 */
@Mapper
public interface AuthenticationMapper {
    @Select("select * from user where username=#{username} and password=#{password} and type=#{type}")
    List<User> listOne(LoginfoDto loginfoDto);

    @Insert("insert into user(username, password, email, type) values(#{username}, #{password}, #{email}, #{type})")
    void insertUser(RegisterInfoDto registerInfoDto);
}
