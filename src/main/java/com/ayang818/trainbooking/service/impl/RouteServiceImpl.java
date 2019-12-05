package com.ayang818.trainbooking.service.impl;

import com.ayang818.trainbooking.mapper.RouteMapper;
import com.ayang818.trainbooking.model.Route;
import com.ayang818.trainbooking.service.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RouteServiceImpl.class);

    @Autowired
    RouteMapper routeMapper;

    @Override
    public void addRoute(String start, String end, String routeCode) {
        Route route = new Route();
        route.setStartStation(start);
        route.setEndStation(end);
        route.setRouteCode(routeCode);
        try {
            routeMapper.insertRoute(route);
        } catch (Exception e) {
            LOGGER.info("{} 路径已存在", routeCode);
        }
    }

    @Override
    public List<Route> listRoutes() {
        return routeMapper.listRoutes();
    }

    @Override
    public void deleteById(Integer routeId) {
        routeMapper.deleteById(routeId);
    }
}
