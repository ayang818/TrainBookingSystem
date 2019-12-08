package com.ayang818.trainbooking.service.impl;

import com.ayang818.trainbooking.dto.SearchDto;
import com.ayang818.trainbooking.mapper.RouteMapper;
import com.ayang818.trainbooking.model.Route;
import com.ayang818.trainbooking.model.Station;
import com.ayang818.trainbooking.service.RouteService;
import com.ayang818.trainbooking.service.StationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RouteServiceImpl implements RouteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RouteServiceImpl.class);
    // 站点的缓存
    private static final Map<Integer, Station> STATION_MAP = new ConcurrentHashMap<>();
    private static final Map<Integer, Route> ROUTE_MAP = new ConcurrentHashMap<>();

    @Autowired
    RouteMapper routeMapper;

    @Autowired
    StationService stationService;

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

    @Override
    public Route selectById(Integer routeId) {
        if (ROUTE_MAP.containsKey(routeId)) {
            return ROUTE_MAP.get(routeId);
        } else {
            Route route = routeMapper.selectById(routeId);
            ROUTE_MAP.put(routeId, route);
            return route;
        }
    }

    @Override
    public String parseCodeToDetails(String routeCode) {
        String[] routeCodes = routeCode.split("-");
        StringBuilder routeDetails = new StringBuilder();
        int index = 0;
        for (String code : routeCodes) {
            Integer id = Integer.valueOf(code);
            if (STATION_MAP.containsKey(id)) {
                routeDetails.append(STATION_MAP.get(id).getStationName());
            } else {
                LOGGER.info("未击中站点缓存");
                Station station = stationService.selectOne(id);
                routeDetails.append(station.getStationName());
                STATION_MAP.put(id, station);
            }
            if (index != routeCodes.length - 1) {
                routeDetails.append("-->");
            }
            index++;
        }
        return  routeDetails.toString();
    }

    @Override
    public Route selectByStartAndEnd(Integer startStation, Integer endStation) {
        SearchDto searchDto = new SearchDto();
        searchDto.setStartStation(startStation);
        searchDto.setEndStation(endStation);
        return routeMapper.selectByStartAndEnd(searchDto);
    }

    @Override
    public Station parseStationById(String startStation) {
        Integer id = Integer.valueOf(startStation);
        if (STATION_MAP.containsKey(id)) {
            return STATION_MAP.get(id);
        } else {
            return stationService.selectOne(id);
        }
    }
}
