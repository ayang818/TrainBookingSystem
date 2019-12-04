package com.ayang818.trainbooking.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName AdminController
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/12/4 21:37
 **/
@Controller
public class AdminController {
    @GetMapping("/admin/station")
    public String getStation() {
        return "admin/station";
    }

    @GetMapping("/admin/addStation")
    public String getAddStation() {
        return "admin/addStation";
    }

    @GetMapping("/admin/route")
    public String getRoute() {
        return "admin/route";
    }

    @GetMapping("/admin/addRoute")
    public String getAddRoute() {
        return "admin/addRoute";
    }

    @GetMapping("/admin/trainNumber")
    public String getTrainNumber() {
        return "admin/trainNumber";
    }

    @GetMapping("/admin/addTrainNumber")
    public String getAddTrainNumber() {
        return "admin/addTrainNumber";
    }
}
