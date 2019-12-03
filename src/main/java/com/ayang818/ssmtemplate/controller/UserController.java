package com.ayang818.ssmtemplate.controller;

import com.ayang818.ssmtemplate.model.User;
import com.ayang818.ssmtemplate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String list(Model model) {
        List<User> userList = userService.list();
        model.addAttribute("userList", userList);
        return "index";
    }

}
