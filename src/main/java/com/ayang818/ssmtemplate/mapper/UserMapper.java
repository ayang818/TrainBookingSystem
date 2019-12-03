package com.ayang818.ssmtemplate.mapper;

import com.ayang818.ssmtemplate.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> list();
}
