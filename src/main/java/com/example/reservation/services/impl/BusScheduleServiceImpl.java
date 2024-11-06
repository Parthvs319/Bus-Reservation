package com.example.reservation.services.impl;

import com.example.reservation.ReservationApplication;
import com.example.reservation.entities.BusRoute;
import com.example.reservation.entities.BusSchedule;
import com.example.reservation.model.ReservationApiException;
import com.example.reservation.repos.BusRouteRepository;
import com.example.reservation.repos.BusScheduleRepository;
import com.example.reservation.services.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusScheduleServiceImpl implements BusScheduleService {
@Autowired
private BusScheduleRepository busScheduleRepository;
@Autowired
private BusRouteRepository busRouteRepository;

    @Override
    public BusSchedule addSchedule(BusSchedule busSchedule) throws ReservationApiException {
        if(busScheduleRepository.existsByBusAndBusRouteAndDepartureTime(busSchedule.getBus(),busSchedule.getBusRoute(),busSchedule.getDepartureTime())){
            throw new ReservationApiException(HttpStatus.CONFLICT,"Duplicate Schedule");
        }
        return busScheduleRepository.save(busSchedule);
    }

    @Override
    public List<BusSchedule> getAllSchedules() {
        return busScheduleRepository.findAll();
    }

    @Override
    public List<BusSchedule> getScheduleByRoute(String route) {
        final BusRoute busRoute=busRouteRepository.findByRouteName(route).orElseThrow(()->new ReservationApiException(HttpStatus.BAD_REQUEST,"Not Found"));
        return  busScheduleRepository.findByBusRoute(busRoute).orElseThrow(()->new ReservationApiException(HttpStatus.BAD_REQUEST,"Not Found"));
    }
}
