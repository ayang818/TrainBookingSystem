package com.ayang818.trainbooking.service;

import com.ayang818.trainbooking.model.Route;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RouteService {
    void addRoute(String start, String end, String routeCode);

    List<Route> listRoutes();

    void deleteById(Integer routeId);
}
