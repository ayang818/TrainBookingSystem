package com.ayang818.trainbooking.mapper;

import com.ayang818.trainbooking.model.Route;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RouteMapper {
    @Insert("insert into route(start_station, end_station, route_code) values(#{startStation}, #{endStation}, #{routeCode})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertRoute(Route route);

    @Select("select * from route")
    List<Route> listRoutes();

    @Delete("delete from route where id=#{routeId}")
    void deleteById(Integer routeId);
}
