package com.ayang818.trainbooking.service;

import com.ayang818.trainbooking.dto.SearchDto;
import com.ayang818.trainbooking.model.TrainNumber;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SearchTicketService
 * @Description TODO
 * @Author 杨丰畅
 * @Date 2019/12/8 22:51
 **/
@Service
public interface SearchTicketService {

    List<TrainNumber> search(SearchDto searchDto);
}
