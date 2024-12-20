package com.example.reservation.model;

import org.springframework.http.HttpStatus;

public class ReservationApiException extends RuntimeException{
    private final HttpStatus httpStatus;
    private final String message;

    public ReservationApiException(HttpStatus httpStatus,String message){
        this.httpStatus=httpStatus;
        this.message=message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
