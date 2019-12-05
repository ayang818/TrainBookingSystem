package com.ayang818.trainbooking.controller.admin;

import com.ayang818.trainbooking.model.Station;
import com.ayang818.trainbooking.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
     * Desc 路线
     * @return
     */
    @GetMapping("/admin/route")
    public String getRoute() {
        return "admin/route";
    }

    @GetMapping("/admin/addRoute")
    public String getAddRoute() {
        return "admin/addRoute";
    }

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
