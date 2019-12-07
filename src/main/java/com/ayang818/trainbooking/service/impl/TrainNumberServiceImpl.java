package com.ayang818.trainbooking.service.impl;

import com.ayang818.trainbooking.mapper.TrainNumberMapper;
import com.ayang818.trainbooking.model.TrainNumber;
import com.ayang818.trainbooking.service.TrainNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TrainNumberServiceImpl
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/12/5 23:53
 **/
@Service
public class TrainNumberServiceImpl implements TrainNumberService {

    @Autowired
    private TrainNumberMapper trainNumberMapper;

    @Override
    public void addTrainNumber(TrainNumber trainNumber) {
        trainNumberMapper.insert(trainNumber);
    }

    @Override
    public List<TrainNumber> listTrainNumber() {
        return trainNumberMapper.list();
    }

    @Override
    public void deleteById(Integer trainNumberId) {
        trainNumberMapper.deleteById(trainNumberId);
    }
}
