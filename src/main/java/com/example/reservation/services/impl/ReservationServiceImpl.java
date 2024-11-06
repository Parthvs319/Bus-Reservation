package com.example.reservation.services.impl;

import com.example.reservation.entities.BusSchedule;
import com.example.reservation.entities.Customer;
import com.example.reservation.entities.Reservation;
import com.example.reservation.model.ReservationApiException;
import com.example.reservation.repos.BusScheduleRepository;
import com.example.reservation.repos.CustomerRepository;
import com.example.reservation.repos.ReservationRespository;
import com.example.reservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationRespository reservationRespository;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BusScheduleRepository busScheduleRepository;
    @Override
    public Reservation addReservation(Reservation reservation) {
        final Customer customer;
        final boolean doesCustomerExists=customerRepository.existsByMobileOrEmail(reservation.getCustomer().getMobile(),reservation.getCustomer().getEmail());
        if(doesCustomerExists){
            customer=customerRepository.findByMobileOrEmail(reservation.getCustomer().getMobile(),reservation.getCustomer().getEmail()).orElseThrow();
        }
        else{
            customer=customerRepository.save(reservation.getCustomer());
        }
    reservation.setCustomer(customer);
    return reservationRespository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRespository.findAll();
    }

    @Override
    public List<Reservation> getReservationByScheduleAndDepartureDate(Long scheduleId, String departureDate) {
        final BusSchedule schedule=busScheduleRepository.findById(scheduleId).orElseThrow(()-> new ReservationApiException(HttpStatus.BAD_REQUEST,"Schedule Not Found"));
        return reservationRespository.findByBusScheduleAndDepartureDate(schedule,departureDate).orElseThrow(()-> new ReservationApiException(HttpStatus.BAD_REQUEST,"Reservation not found"));
    }

    @Override
    public List<Reservation> getReservationByMobile(String mobile) {
        final Customer customer=customerRepository.findByMobile(mobile).orElseThrow(()->new ReservationApiException(HttpStatus.BAD_REQUEST,"No record found"));
        return reservationRespository.findByCustomer(customer).orElseThrow(()-> new ReservationApiException(HttpStatus.BAD_REQUEST,""));
    }
}
