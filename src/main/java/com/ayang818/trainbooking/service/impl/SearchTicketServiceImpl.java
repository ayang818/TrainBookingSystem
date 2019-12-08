package com.ayang818.trainbooking.service.impl;

import com.ayang818.trainbooking.dto.SearchDeeperDto;
import com.ayang818.trainbooking.dto.SearchDto;
import com.ayang818.trainbooking.mapper.SearchTicketMapper;
import com.ayang818.trainbooking.model.Route;
import com.ayang818.trainbooking.model.TrainNumber;
import com.ayang818.trainbooking.service.RouteService;
import com.ayang818.trainbooking.service.SearchTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SearchTicketServiceImpl
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/12/8 22:52
 **/
@Service
public class SearchTicketServiceImpl implements SearchTicketService {

    @Autowired
    private SearchTicketMapper searchTicketMapper;

    @Autowired
    private RouteService routeService;

    @Override
    public List<TrainNumber> search(SearchDto searchDto) {
        Route route = routeService.selectByStartAndEnd(searchDto.getStartStation(), searchDto.getEndStation());
        SearchDeeperDto searchDeeperDto = new SearchDeeperDto();
        searchDeeperDto.setRouteId(route.getId());
        searchDeeperDto.setStartTime(searchDto.getStartTime()+"%");
        return searchTicketMapper.listByParam(searchDeeperDto);
    }
}
