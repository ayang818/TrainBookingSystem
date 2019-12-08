package com.ayang818.trainbooking.controller;

import com.ayang818.trainbooking.constpool.UserType;
import com.ayang818.trainbooking.dto.LoginfoDto;
import com.ayang818.trainbooking.dto.RegisterInfoDto;
import com.ayang818.trainbooking.model.User;
import com.ayang818.trainbooking.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @ClassName AuthenticationController
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/12/3 23:27
 **/
@Controller
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(HttpServletRequest request, HttpServletResponse response, @RequestParam String username,
                          @RequestParam String password,
                          @RequestParam Integer type) {
        if (username == null || password == null || "".equals(username) || "".equals(password)) {
            return "login";
        }
        LOGGER.info("用户:{}尝试登录", username);
        LoginfoDto loginfoDto = new LoginfoDto();
        loginfoDto.setUsername(username);
        loginfoDto.setPassword(password);
        loginfoDto.setType(type);
        User user = authenticationService.tryLogin(loginfoDto);
        if (user == null) {
            LOGGER.info("用户:{}登录失败", username);
            return "login";
        }
        LOGGER.info("用户:{}登录成功", username);
        request.getSession().setAttribute("userName", username);
        if (Objects.equals(user.getType(), UserType.ADMIN)) {
            return "redirect:admin/station";
        } else {
            return "redirect:user/searchTicket";
        }
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String email) {
        if (username == null || password == null || email == null || "".equals(username) || "".equals(password) || "".equals(email)) {
            return "register";
        }
        LOGGER.info("用户:{}尝试注册, 邮箱:{}", username, email);
        RegisterInfoDto registerInfoDto = new RegisterInfoDto();
        registerInfoDto.setUsername(username);
        registerInfoDto.setPassword(password);
        registerInfoDto.setEmail(email);
        registerInfoDto.setType(UserType.USER);
        if (!authenticationService.tryRegister(registerInfoDto)) {
            return "register";
        }
        LOGGER.info("用户:{}注册成功, 邮箱:{}", username, email);
        return "redirect:login";
    }
}