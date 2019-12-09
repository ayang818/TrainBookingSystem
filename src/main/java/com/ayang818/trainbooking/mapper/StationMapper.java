package com.ayang818.trainbooking.mapper;

import com.ayang818.trainbooking.model.Station;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @desc 站点数据库操作
 * @author 杨丰畅
 */
@Mapper
public interface StationMapper {
    @Insert("insert into station(station_name) values(#{stationName})")
    void insertStation(String stationName);

    @Select("select * from station")
    List<Station> listStation();

    @Delete("delete from station where id=#{stationId}")
    void deleteStation(Integer stationId);

    @Update("update station set station_name=#{stationName} where id = #{stationId}")
    void updateStation(Integer stationId, String stationName);

    @Select("select * from station where id=${id}")
    Station selectOne(Integer id);
}
