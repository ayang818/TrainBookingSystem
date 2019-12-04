package com.ayang818.trainbooking.mapper;

import com.ayang818.trainbooking.dto.LoginfoDto;
import com.ayang818.trainbooking.dto.RegisterInfoDto;
import com.ayang818.trainbooking.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuthenticationMapper {
    @Select("select * from user where username=#{username}, password=#{password}")
    List<User> listOne(LoginfoDto loginfoDto);

    @Insert("insert into user(username, password, email) values(#{username}, #{password}, #{email})")
    void insertUser(RegisterInfoDto registerInfoDto);
}
