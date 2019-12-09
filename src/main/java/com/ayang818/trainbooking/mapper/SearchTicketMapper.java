package com.ayang818.trainbooking.mapper;

import com.ayang818.trainbooking.dto.SearchDeeperDto;
import com.ayang818.trainbooking.dto.SearchDto;
import com.ayang818.trainbooking.model.TrainNumber;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @desc 用户查询数据库操作
 * @author 杨丰畅
 */
public interface SearchTicketMapper {

    @Select("select * from train_number where route_id=#{routeId} and start_time like #{startTime}")
    List<TrainNumber> listByParam(SearchDeeperDto searchDeeperDto);
}
