package com.ayang818.trainbooking.service;

import org.springframework.stereotype.Service;

@Service
public interface RouteService {
    void addRoute(String start, String end, String routeCode);
}
