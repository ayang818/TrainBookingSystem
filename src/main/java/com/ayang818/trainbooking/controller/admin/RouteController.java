package com.ayang818.trainbooking.controller.admin;

import com.ayang818.trainbooking.model.Route;
import com.ayang818.trainbooking.model.Station;
import com.ayang818.trainbooking.service.RouteService;
import com.ayang818.trainbooking.service.StationService;
import com.ayang818.trainbooking.service.impl.RouteServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @desc 路线相关控制器
 * @author 杨丰畅
 */
@Controller
public class RouteController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RouteController.class);
    public static final Map<Integer, Station> HASH_MAP = new ConcurrentHashMap<>();

    @Autowired
    RouteService routeService;

    @Autowired
    StationService stationService;

    @PostMapping("/admin/addRoute")
    public String doAddRoute(@RequestParam String startStation,
                             @RequestParam String endStation,
                             @RequestParam String routeCode) {
        LOGGER.info("start is {} end is {}", startStation, endStation);
        LOGGER.info("routeCode is {}", routeCode);
        String[] stations = routeCode.split("-");
        int count = 0;
        List<Route> routes = new ArrayList<>();
        Integer startStationId;
        Integer endStationId;
        for (int i = 2; i <= stations.length; i++) {
            for (int j = 0; j < stations.length - i + 1; j++) {
                StringBuilder stringBuilder = new StringBuilder();
                Route route = new Route();
                // 找到所有子路径
                for (int k = j; k < j+i; k++) {
                    if (k == j) {
                        //startStationId = Integer.valueOf(stations[k]);
                        //Station station = stationService.selectOne(startStationId);
                        route.setStartStation(stations[k]);
                    }
                    if (k == j+i-1) {
                        //endStationId = Integer.valueOf(stations[k]);
                        //Station station = stationService.selectOne(endStationId);
                        route.setEndStation(stations[k]);
                    }
                    stringBuilder.append(stations[k]);
                    if (k != j+i-1) {
                        stringBuilder.append("-");
                    }
                }
                route.setRouteCode(stringBuilder.toString());
                count++;
                routes.add(route);
            }
        }
        LOGGER.info("最长路线为{}, 共解析出{}条路线", Arrays.toString(stations), count*2);
        for (Route route : routes) {
            StringBuilder reverseString = new StringBuilder();
            String[] code = route.getRouteCode().split("-");
            // 逆序code
            for (int i = code.length - 1; i >= 0; i--) {
                reverseString.append(code[i]);
                if (i != 0) {
                    reverseString.append("-");
                }
            }
            // 添加逆序的路线
            routeService.addRoute(route.getEndStation(), route.getStartStation(), reverseString.toString());
            // 添加正序路线
            routeService.addRoute(route.getStartStation(), route.getEndStation(), route.getRouteCode());
        }
        return "redirect:/admin/addRoute";
    }

    @GetMapping("/admin/route")
    public String getRoute(HttpServletRequest request, HttpServletResponse response) {
        List<Route> routes = routeService.listRoutes();
        LOGGER.info("开始解析路线途经站点");
        for (Route route : routes) {
            Station startStation = routeService.parseStationById(route.getStartStation());
            route.setStartStation(startStation.getStationName());
            Station endStation = routeService.parseStationById(route.getEndStation());
            route.setEndStation(endStation.getStationName());
            String routeCode = route.getRouteCode();
            route.setStationDetails(routeService.parseCodeToDetails(routeCode));
        }
        LOGGER.info("解析路线完毕");
        request.getSession().setAttribute("routes", routes);
        return "admin/route";
    }

    @GetMapping("/admin/addRoute")
    public String getAddRoute(HttpServletRequest request, HttpServletResponse response) {
        List<Station> stations = stationService.listStation();
        request.getSession().setAttribute("stations", stations);
        return "admin/addRoute";
    }

    @GetMapping("/admin/deleteRoute")
    public String deleteRoute(@RequestParam Integer routeId) {
        routeService.deleteById(routeId);
        return "redirect:/admin/route";
    }

    public Map<Integer, Station> getCache() {
        return  HASH_MAP;
    }
}
