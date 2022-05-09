package com.project.OpenXinternshiptask.service;

import com.project.OpenXinternshiptask.model.Cart;
import com.project.OpenXinternshiptask.model.Geolocation;
import com.project.OpenXinternshiptask.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UserService {

    final static String URL_USERS = "https://fakestoreapi.com/users";
    private final RestTemplate restTemplate;

    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public User getUserById(@RequestParam Long id){

        final ResponseEntity<User[]> forEntity1 = restTemplate.getForEntity(
                URL_USERS,
                User[].class
        );
        return Arrays.stream(Objects.requireNonNull(forEntity1.getBody())).filter(user -> user.getId().equals(id)).findFirst().orElseThrow();
    }

    public List<User> getTwoFurthersUser(){

        User firstUserToReturn = new User();
        User secondUserToReturn = new User();
        double maxDistance = 0;
        double actualDistance = 0;
        final User[] allUsers = getAllUsers();
        for(User firstUser:allUsers){
            for (User secondUser:allUsers){
                actualDistance = calculateDistance(
                        firstUser.getAddress().getGeolocation(),secondUser.getAddress().getGeolocation()
                );

                if(actualDistance > maxDistance){
                    maxDistance = actualDistance;
                    firstUserToReturn = firstUser;
                    secondUserToReturn = secondUser;
                }

            }
        }
        return List.of(firstUserToReturn,secondUserToReturn);
    }

    private User[] getAllUsers(){
        return restTemplate.getForEntity(
                URL_USERS,
                User[].class
        ).getBody();
    }

    private double calculateDistance(Geolocation firstUser, Geolocation secondUser){
        return Math.sqrt(
                Math.pow(firstUser.getLatitude() - secondUser.getLatitude(),2)
                        + Math.pow(firstUser.getLongitude() - secondUser.getLongitude(),2));
    }
}
