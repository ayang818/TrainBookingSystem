package com.ayang818.trainbooking.mapper;

import com.ayang818.trainbooking.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @desc 用户数据库操作
 * @author 杨丰畅
 */
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> list();
}
