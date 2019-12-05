package com.ayang818.trainbooking.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Route {
    private Integer id;
    private String startStation;
    private String endStation;
    private String routeCode;
    private List<Station> stationList;
}
