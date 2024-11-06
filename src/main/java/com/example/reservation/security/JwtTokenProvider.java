package com.example.reservation.security;

import com.example.reservation.model.ReservationApiException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${app.jwt-secret}")
    private  String jwtSecretkey;

    @Value("${app-jwt-expiration-milliseconds}")
    private Long expiration;

    //Method for generation of a token.
    public String generateToken(Authentication authentication){
        //Authentication is an object present in spring security
        //Inside this object we get the actual credentials like username and password

        String username=authentication.getName();
        Date expireDate=new Date(new Date().getTime()+ expiration);
        return Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(expireDate).signWith(key()).compact() ;
    }
    public String getUsername(String token){
        Claims claims=Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    //To validate the token
    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(key()).build().parse(token);
            return true;
        }catch (MalformedJwtException malformedJwtException){
            throw new ReservationApiException(HttpStatus.BAD_REQUEST,"Invalid Token");
        }
        catch (ExpiredJwtException expiredJwtException){
             throw new ReservationApiException(HttpStatus.BAD_REQUEST,"Token Expired");
        }
        catch (UnsupportedJwtException unsupportedJwtException){
            throw new ReservationApiException(HttpStatus.BAD_REQUEST,"Unsupported Token");
        }
        catch (IllegalArgumentException illegalArgumentException){
            throw new ReservationApiException(HttpStatus.BAD_REQUEST,"Invalid argument");
        }
    }

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecretkey));
    }

}
