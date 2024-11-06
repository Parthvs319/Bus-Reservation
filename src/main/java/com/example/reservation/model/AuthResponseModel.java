package com.example.reservation.model;


//This class will be used to return a response against authentication.
//It will be used to pass the JWT along with the successful login information to the client.


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponseModel {

    private int statusCode;
    private String message;
    private String accessToken;
    private Long loginTime;
    private Long expirationDuration;
}
