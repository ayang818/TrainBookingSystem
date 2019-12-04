package com.ayang818.trainbooking.utils;

import com.alibaba.fastjson.JSON;
import com.ayang818.trainbooking.constpool.JwtKey;
import com.ayang818.trainbooking.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JwtUtil
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/12/4 19:36
 **/
public class JwtUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtil.class);

    public static String createJWT(String jsonString) {
        String jwt = null;
        try {
            jwt = JwtUtil.createJWT(JwtKey.JWT_ID, "admin", jsonString, JwtKey.JWT_TTL);
        } catch (Exception e) {
            LOGGER.error("生成jwt密钥失败, 传入json {}", jsonString);
        }
        return jwt;
    }

    public static Claims parseJWT(String jwt) {
        SecretKey key = generalKey();
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    private static SecretKey generalKey() {
        String stringKey = JwtKey.SECRETKEY;
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        // 根据给定的字节数组使用AES加密算法构造一个密钥
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    private static String createJWT(String id, String issuer, String subject, long ttlMillis) throws Exception {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        // 生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Map<String, Object> claims = new HashMap<>();
        claims.put("uid", "1");
        claims.put("user_name", "admin");
        SecretKey key = generalKey();

        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setId(id)
                .setIssuedAt(now)
                .setIssuer(issuer)
                // sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
                .setSubject(subject)
                .signWith(signatureAlgorithm, key);

        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }
    //public static void main(String[] args) throws Exception {
    //    User user = new User();
    //    user.setUsername("ayang818");
    //    user.setPassword("123");
    //    String s = JSON.toJSONString(user);
    //    String jwt = JwtUtil.createJWT(s);
    //    Claims claims = JwtUtil.parseJWT(jwt);
    //    System.out.println(claims.getSubject());
    //}
}
