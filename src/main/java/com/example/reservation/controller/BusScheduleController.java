package com.example.reservation.controller;

import com.example.reservation.entities.BusSchedule;
import com.example.reservation.model.ResponseModel;
import com.example.reservation.services.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class BusScheduleController {

    @Autowired
    private BusScheduleService busScheduleService;

    @PostMapping("/add")
    public ResponseModel<BusSchedule> addBusSchedule(@RequestBody BusSchedule busSchedule){
        final BusSchedule schedule=busScheduleService.addSchedule(busSchedule);
        return new ResponseModel<>(HttpStatus.OK.value(),"Schedule Saved",schedule);
    }


    @GetMapping("/all")
    public ResponseEntity<List<BusSchedule>> getAllSchedule(){
        return ResponseEntity.ok(busScheduleService.getAllSchedules());
    }

    @GetMapping("/{routeName}")
    public ResponseEntity<List<BusSchedule>> getBusScheduleByRouteName(@PathVariable(name="routeName") String routeName){
        return ResponseEntity.ok(busScheduleService.getScheduleByRoute(routeName));
    }
}
