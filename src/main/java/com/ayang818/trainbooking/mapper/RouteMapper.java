package com.ayang818.trainbooking.mapper;

import com.ayang818.trainbooking.model.Route;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RouteMapper {
    @Insert("insert into route(start_station, end_station, route_code) values(route.startStation, route.endStation, route.routeCode)")
    void insertRoute(Route route);
}
