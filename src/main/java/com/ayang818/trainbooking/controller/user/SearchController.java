package com.ayang818.trainbooking.controller.user;

import com.ayang818.trainbooking.dto.SearchDto;
import com.ayang818.trainbooking.model.Route;
import com.ayang818.trainbooking.model.Station;
import com.ayang818.trainbooking.model.TrainNumber;
import com.ayang818.trainbooking.service.RouteService;
import com.ayang818.trainbooking.service.SearchTicketService;
import com.ayang818.trainbooking.service.StationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @ClassName SearchController
 * @Description 用户查询相关控制器
 * @Author 杨丰畅
 * @Date 2019/12/8 20:17
 **/
@Controller
public class SearchController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private StationService stationService;

    @Autowired
    private SearchTicketService searchTicketService;

    @Autowired
    private RouteService routeService;

    @PostMapping("/user/searchTicket")
    public String doSearchTicket(HttpServletRequest request,
                                 HttpServletResponse response,
                                 @RequestParam Integer startStation,
                                 @RequestParam Integer endStation,
                                 @RequestParam String startTime) {
        SearchDto searchDto = new SearchDto();
        searchDto.setStartStation(startStation);
        searchDto.setEndStation(endStation);
        searchDto.setStartTime(startTime);
        List<TrainNumber> trainNumbers = searchTicketService.search(searchDto);
        for (TrainNumber trainNumber : trainNumbers) {
            Integer routeId = trainNumber.getRouteId();
            Route route = routeService.selectById(routeId);
            trainNumber.setRouteDetail(routeService.parseCodeToDetails(route.getRouteCode()));
        }
        LOGGER.info(trainNumbers.toString());
        request.getSession().setAttribute("results", trainNumbers);
        return "redirect:/user/searchTicket";
    }

    @GetMapping("/user/searchTicket")
    public String searchTicket(HttpServletRequest request, HttpServletResponse response) {
        List<Station> stations = stationService.listStation();
        request.getSession().setAttribute("stations", stations);
        return "user/search";
    }
}
