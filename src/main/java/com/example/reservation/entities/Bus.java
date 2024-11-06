package com.example.reservation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// Lombok is used to remove the setter getter code and the constructor code from class
@Entity(name="bus")
public class Bus {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long busId;
    private String busName;
    private String busType;
    private Integer totalSeat;
@Column(unique = true)
    private String busNumber;
}
