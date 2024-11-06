package com.example.reservation.services;

import com.example.reservation.entities.AppUsers;
import com.example.reservation.repos.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;


   //This is a predefined function present in the UserDetailsService interface provided by Spring Security.
    //This is used to specify where the credentials are stored.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final AppUsers appUsers=appUserRepository.findByUserName(username).orElseThrow(()->new UsernameNotFoundException("User does not exists"));
        return User.builder().username(appUsers.getUserName()).password(appUsers.getPassword()).roles(appUsers.getRole()).build();
    }
}

