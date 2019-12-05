package com.ayang818.trainbooking.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);



    /**
     * Desc 车次
     * @return
     */
    @GetMapping("/admin/trainNumber")
    public String getTrainNumber() {
        return "admin/trainNumber";
    }

    @GetMapping("/admin/addTrainNumber")
    public String getAddTrainNumber() {
        return "admin/addTrainNumber";
    }
}
