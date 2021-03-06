package com.ayang818.trainbooking.service.impl;

import com.ayang818.trainbooking.mapper.StationMapper;
import com.ayang818.trainbooking.model.Station;
import com.ayang818.trainbooking.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc 站点操作业务逻辑封装
 * @author 杨丰畅
 */
@Service
public class StationServiceImpl implements StationService {
    @Autowired
    StationMapper stationMapper;

    @Override
    public Boolean addStation(String stationName) {
        stationMapper.insertStation(stationName);
        return true;
    }

    @Override
    public List<Station> listStation() {
        return stationMapper.listStation();
    }

    @Override
    public void deleteStation(Integer stationId) {
        stationMapper.deleteStation(stationId);
    }

    @Override
    public void modifyStation(Integer stationId, String stationName) {
        stationMapper.updateStation(stationId, stationName);
    }

    @Override
    public Station selectOne(Integer id) {
        Station station = stationMapper.selectOne(id);
        return station;
    }
}
