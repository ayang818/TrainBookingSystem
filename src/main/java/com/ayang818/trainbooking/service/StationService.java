package com.ayang818.trainbooking.service;

import com.ayang818.trainbooking.model.Station;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StationService {
    Boolean addStation(String stationName);
    List<Station> listStation();
    void deleteStation(Integer stationId);
    void modifyStation(Integer stationId, String stationName);
    Station selectOne(Integer id);
}
