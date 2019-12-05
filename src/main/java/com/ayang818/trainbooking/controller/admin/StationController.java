package com.ayang818.trainbooking.controller.admin;

import com.ayang818.trainbooking.model.Station;
import com.ayang818.trainbooking.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class StationController {
    @Autowired
    StationService stationService;

    @PostMapping("/admin/addStation")
    public String doAddStation(@RequestParam String stationName) {
        stationService.addStation(stationName);
        return  null;
    }

    @GetMapping("/admin/deleteStation")
    public String doDeleteStation(@RequestParam Integer stationId) {
        stationService.deleteStation(stationId);
        return "redirect:/admin/station";
    }

    @GetMapping("/admin/modifyStation")
    public String doModifyStation(@RequestParam Integer stationId, @RequestParam String stationName) {
        stationService.modifyStation(stationId, stationName);
        return "redirect:/admin/station";
    }

    @GetMapping("/admin/station")
    public String getStation(HttpServletRequest request, HttpServletResponse response) {
        List<Station> stations = stationService.listStation();
        request.getSession().setAttribute("stations", stations);
        return "admin/station";
    }

    @GetMapping("/admin/addStation")
    public String getAddStation() {
        return "admin/addStation";
    }
}
