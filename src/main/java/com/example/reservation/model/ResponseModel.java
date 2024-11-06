package com.example.reservation.model;

import com.example.reservation.entities.Bus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel<T>{
    private int statusCode;
    private String message;
    private T response;
}
