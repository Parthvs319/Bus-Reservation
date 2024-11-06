package com.example.reservation.services;

import com.example.reservation.entities.BusSchedule;

import java.util.List;

public interface BusScheduleService {
    BusSchedule addSchedule(BusSchedule busSchedule);

    List<BusSchedule> getAllSchedules();

    List<BusSchedule> getScheduleByRoute(String route);
}
