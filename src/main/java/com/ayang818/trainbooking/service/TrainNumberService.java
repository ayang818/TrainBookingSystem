package com.ayang818.trainbooking.service;

import com.ayang818.trainbooking.model.TrainNumber;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TrainNumberService
 * @Description TODO
 * @Author 杨丰畅
 * @Date 2019/12/5 23:52
 **/
@Service
public interface TrainNumberService {

    void addTrainNumber(TrainNumber trainNumber);

    List<TrainNumber> listTrainNumber();

    void deleteById(Integer trainNumberId);

}
