package com.example.reservation.services;

import com.example.reservation.entities.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation addReservation(Reservation reservation);
    List<Reservation> getAllReservation();
    List<Reservation> getReservationByScheduleAndDepartureDate(Long scheduleId,String departureDate);
    List<Reservation> getReservationByMobile(String mobile);
}
