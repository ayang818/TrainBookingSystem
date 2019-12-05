package com.ayang818.trainbooking.service.impl;

import com.ayang818.trainbooking.mapper.RouteMapper;
import com.ayang818.trainbooking.model.Route;
import com.ayang818.trainbooking.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    RouteMapper routeMapper;

    @Override
    public void addRoute(String start, String end, String routeCode) {
        Route route = new Route();
        route.setStartStation(start);
        route.setEndStation(end);
        route.setRouteCode(routeCode);
        routeMapper.insertRoute(route);
    }
}
