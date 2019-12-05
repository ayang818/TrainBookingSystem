package com.ayang818.trainbooking.controller.admin;

import com.ayang818.trainbooking.service.RouteService;
import com.ayang818.trainbooking.service.impl.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteController {
    @Autowired
    RouteService routeService;

    @PostMapping("/admin/addRoute")
    public String doAddRoute(@RequestParam String startStation,
                             @RequestParam String endStation,
                             @RequestParam String routeCode) {
        routeService.addRoute(startStation, endStation, routeCode);
        return "redirect:/admin/addRoute";
    }

    @GetMapping("/admin/route")
    public String getRoute() {
        return "admin/route";
    }

    @GetMapping("/admin/addRoute")
    public String getAddRoute() {
        return "admin/addRoute";
    }
}
