package com.ayang818.trainbooking.model;

import lombok.Data;

@Data
public class Route {
    private Integer id;
    private String startStation;
    private String endStation;
    private String routeCode;
    private String stationDetails;
}
