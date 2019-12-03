package com.ayang818.trainbooking.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName AuthenticationController
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/12/3 23:27
 **/
@Controller
public class AuthenticationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username,
                          @RequestParam String password) {
        System.out.println(username +"&"+ password);
        return null;
    }

    @GetMapping("/register")
    public String register() {
        return null;
    }

    @PostMapping("/register")
    public String doRegister(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String email) {
        System.out.println(username + "&" + password + "&" + email);
        return null;
    }
}