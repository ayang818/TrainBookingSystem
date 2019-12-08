package com.ayang818.trainbooking.controller.admin;

import com.ayang818.trainbooking.model.Route;
import com.ayang818.trainbooking.model.Station;
import com.ayang818.trainbooking.model.TrainNumber;
import com.ayang818.trainbooking.service.RouteService;
import com.ayang818.trainbooking.service.StationService;
import com.ayang818.trainbooking.service.TrainNumberService;
import com.ayang818.trainbooking.service.impl.RouteServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TrainNumberController
 * @Dessription TODO
 * @Author 杨丰畅
 * @Date 2019/12/5 23:51
 **/
@Controller
public class TrainNumberController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TrainNumberController.class);
    public static final String FORMAT_PATTERN = "YYYY-MM-DD HH:mm";
    @Autowired
    TrainNumberService trainNumberService;

    @Autowired
    RouteService routeService;

    @Autowired
    StationService stationService;

    @PostMapping("/admin/addTrainNumber")
    public String doAddTrainNumber(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam Integer routeId,
                                   @RequestParam String trainId,
                                   @RequestParam String startTime,
                                   @RequestParam String endTime,
                                   @RequestParam Integer ticketNumber) {
        LocalDateTime startTimeFormat = LocalDateTime.parse(startTime);
        LocalDateTime endTimeFormat = LocalDateTime.parse(endTime);
        TrainNumber trainNumber = new TrainNumber();
        trainNumber.setRouteId(routeId);
        trainNumber.setTrainId(trainId);
        trainNumber.setStartTime(startTimeFormat);
        trainNumber.setEndTime(endTimeFormat);
        trainNumber.setTicketNumber(ticketNumber);
        LOGGER.info(trainNumber.toString());
        trainNumberService.addTrainNumber(trainNumber);
        return "redirect:/admin/addTrainNumber";
    }

    @GetMapping("/admin/deleteTrainNumber")
    public String deleteTrainNumber(@RequestParam Integer trainNumberId) {
        trainNumberService.deleteById(trainNumberId);
        return "redirect:/admin/trainNumber";
    }

    @GetMapping("/admin/trainNumber")
    public String getTrainNumber(HttpServletRequest request, HttpServletResponse response) {
        List<TrainNumber> trainNumbers = trainNumberService.listTrainNumber();
        for (TrainNumber trainNumber : trainNumbers) {
            Route route = routeService.selectById(trainNumber.getRouteId());
            String routeCode = route.getRouteCode();
            String routeDetails = routeService.parseCodeToDetails(routeCode);
            trainNumber.setRouteDetail(routeDetails);
        }
        request.getSession().setAttribute("trainNumbers", trainNumbers);
        return "admin/trainNumber";
    }

    @GetMapping("/admin/addTrainNumber")
    public String getAddTrainNumber(HttpServletRequest request, HttpServletResponse response) {
        List<Route> routes = routeService.listRoutes();
        for (Route route : routes) {
            route.setStartStation(routeService.parseStationById(route.getStartStation()).getStationName());
            route.setEndStation(routeService.parseStationById(route.getEndStation()).getStationName());
        }
        request.getSession().setAttribute("routes", routes);
        return "admin/addTrainNumber";
    }
}
