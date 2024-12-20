package com.example.reservation.repos;

import com.example.reservation.entities.BusSchedule;
import com.example.reservation.entities.Customer;
import com.example.reservation.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRespository extends JpaRepository<Reservation,Long> {

    Optional<List<Reservation>> findByCustomer(Customer customer);

    Optional<List<Reservation>> findByBusScheduleAndDepartureDate(BusSchedule busSchedule,String departureDate);

}
