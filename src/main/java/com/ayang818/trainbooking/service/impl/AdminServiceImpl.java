package com.ayang818.trainbooking.service.impl;

import com.ayang818.trainbooking.mapper.StationMapper;
import com.ayang818.trainbooking.model.Station;
import com.ayang818.trainbooking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
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
}
