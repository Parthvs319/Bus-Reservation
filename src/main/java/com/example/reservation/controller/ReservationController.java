package com.example.reservation.controller;

import com.example.reservation.entities.Reservation;
import com.example.reservation.model.ResponseModel;
import com.example.reservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/add")
    public ResponseModel<Reservation> addReservation(@RequestBody Reservation reservation){
        final Reservation reservation1=reservationService.addReservation(reservation);
        return new ResponseModel<>(HttpStatus.OK.value(),"Reservation Saved",reservation1);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservation(){
        return ResponseEntity.ok(reservationService.getAllReservation());
    }

    @GetMapping("/query")
    public ResponseEntity<List<Reservation>> getReservationByScheduleAndDeparture(
            @RequestParam Long scheduleId,
            @RequestParam String departureDate
    ){
        return ResponseEntity.ok(reservationService.getReservationByScheduleAndDepartureDate(scheduleId,departureDate));
    }

    @GetMapping("/all/{mobile}")
    public ResponseEntity<List<Reservation>> getReservationByMobile(@PathVariable(name="mobile") String mobile){
        return ResponseEntity.ok(reservationService.getReservationByMobile(mobile));
    }
}
