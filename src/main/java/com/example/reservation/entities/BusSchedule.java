package com.example.reservation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="bus_schedule")
public class BusSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    //One bus will have only one schedule
    //One bus schedule will have only one bus route
    //One to One Mapping
    @OneToOne
    @JoinColumn(name="bus_id")//JPA will create a table names bus_id.
    private Bus bus;

    @OneToOne
    @JoinColumn(name="bus_route_id")//JPA will create a table names bus_route.
    private BusRoute busRoute;

    private String departureTime;
    private Integer ticketPrice;
    private Integer discount;
    private Integer processingFee;
}
