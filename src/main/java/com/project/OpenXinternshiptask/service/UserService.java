package com.project.OpenXinternshiptask.service;

import com.project.OpenXinternshiptask.model.user.Geolocation;
import com.project.OpenXinternshiptask.model.user.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@AllArgsConstructor
public class UserService {

    final static String URL_USERS = "https://fakestoreapi.com/users";
    private final RestTemplate restTemplate;
    private final List<User> users;

    @Autowired
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.users = Arrays.stream(getAllUsers()).toList();
    }

    private User[] getAllUsers(){
        return restTemplate.getForEntity(
                URL_USERS,
                User[].class
        ).getBody();
    }

    public User getUserById(@RequestParam Integer id){
        //index of List is associated with index+1 of our user object, so requested id we need to decrement to get appropriate object from list
        return this.users.get(id-1);
    }

    public List<User> getTwoFurthersUsers(){

        User firstUserToReturn = new User();
        User secondUserToReturn = new User();
        double maxDistance = 0;
        double actualDistance;

        for(User firstUser:users){
            for (User secondUser:users){

                if(firstUser.getId() > secondUser.getId()) continue;

                actualDistance = calculateDistance(
                        firstUser.getAddress().getGeolocation(),
                        secondUser.getAddress().getGeolocation()
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

    private double calculateDistance(Geolocation firstUser, Geolocation secondUser){
        return Math.sqrt(
                Math.pow(secondUser.getLatitude() - firstUser.getLatitude(),2)
                        + Math.pow(secondUser.getLongitude()-firstUser.getLongitude(),2));
    }
}
