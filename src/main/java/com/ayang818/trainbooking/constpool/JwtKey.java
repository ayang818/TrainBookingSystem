package com.ayang818.trainbooking.constpool;

import java.util.UUID;

public interface JwtKey {
    String SECRETKEY = "xixihaha";
    Integer JWT_TTL = 24*3600;
    String JWT_ID = UUID.randomUUID().toString();
}
