package com.example.reservation.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ReservationApiException.class)
public ResponseEntity<ErrorDetails> handleReservationApiException(ReservationApiException exception, WebRequest request){
    final ErrorDetails errorDetails=new ErrorDetails();
    errorDetails.setErrorCode(exception.getHttpStatus().value());
    errorDetails.setErrorMessage(exception.getLocalizedMessage());
    errorDetails.setDevErrorMessage(request.getDescription(false));
    errorDetails.setTimestamp(System.currentTimeMillis());
    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
}
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDetails> handleAcessDeniedException(AccessDeniedException exception, WebRequest request){
        final ErrorDetails errorDetails=new ErrorDetails();
        errorDetails.setErrorMessage(exception.getLocalizedMessage());
        errorDetails.setDevErrorMessage(request.getDescription(false));
        errorDetails.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception, WebRequest request){
        final ErrorDetails errorDetails=new ErrorDetails();
        errorDetails.setErrorMessage(exception.getLocalizedMessage());
        errorDetails.setDevErrorMessage(request.getDescription(false));
        errorDetails.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }
}
