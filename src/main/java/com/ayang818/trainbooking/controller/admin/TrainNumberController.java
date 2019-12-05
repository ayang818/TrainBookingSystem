package com.ayang818.trainbooking.controller.admin;

import com.ayang818.trainbooking.model.Route;
import com.ayang818.trainbooking.service.RouteService;
import com.ayang818.trainbooking.service.TrainNumberService;
import com.ayang818.trainbooking.service.impl.TrainNumberServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName TrainNumberController
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/12/5 23:51
 **/
@Controller
public class TrainNumberController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrainNumberController.class);

    @Autowired
    TrainNumberService trainNumberService;

    @Autowired
    RouteService routeService;

    @PostMapping
    public String doAddTrainNumber(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/admin/addTrainNumber";
    }

    @GetMapping("/admin/trainNumber")
    public String getTrainNumber() {
        return "admin/trainNumber";
    }

    @GetMapping("/admin/addTrainNumber")
    public String getAddTrainNumber(HttpServletRequest request, HttpServletResponse response) {
        List<Route> routes = routeService.listRoutes();
        request.getSession().setAttribute("routes", routes);
        return "admin/addTrainNumber";
    }
}
