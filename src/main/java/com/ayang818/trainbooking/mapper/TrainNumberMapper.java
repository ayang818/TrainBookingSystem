package com.ayang818.trainbooking.mapper;

import com.ayang818.trainbooking.model.TrainNumber;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @desc 车次数据库操作
 * @author 杨丰畅
 */
@Mapper
public interface TrainNumberMapper {

    @Insert("insert into train_number(route_id, train_id, start_time, end_time, ticket_number) values(#{routeId}, #{trainId}, #{startTime}, #{endTime}, #{ticketNumber})")
    void insert(TrainNumber trainNumber);

    @Select("select * from train_number")
    List<TrainNumber> list();

    @Delete("delete from train_number where id = #{trainNumberId}")
    void deleteById(Integer trainNumberId);
}
