package com.ayang818.trainbooking.model;

import lombok.Data;

/**
 * @desc user数据库映射
 * @author 杨丰畅
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Integer type;
}
