package com.ayang818.trainbooking.model;

import lombok.Data;

/**
 * @desc route数据库映射
 * @author 杨丰畅
 */
@Data
public class Route {
    private Integer id;
    private String startStation;
    private String endStation;
    private String routeCode;
    private String stationDetails;
}
