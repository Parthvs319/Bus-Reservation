package com.example.reservation.repos;

import com.example.reservation.entities.BusRoute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusRouteRepository extends JpaRepository<BusRoute,Long> {
    //Some custom methods are required.
    /*Optional is a Special Object in which we can wrap any Object.
    //Any data inside optional is added as a return type.
    //The benifit of optinal is that we can perform the null check and also we can throw some exception
    if bus route is not returned.
    */


    //JPA automatically recognizes the method the entity name.
    //And creates the body of function.
    //For entity routeName,findByRouteName() method body will be automatically given by JPA.

    Optional<BusRoute> findByRouteName(String routeName);

    // Works in the similar way as the above method.
    Optional<BusRoute> findByCityFromAndCityTo(String cityFrom,String cityTo);
}
