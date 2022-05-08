package com.project.OpenXinternshiptask.constroller;

import com.project.OpenXinternshiptask.model.User;
import com.project.OpenXinternshiptask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class UserController {

    final static String URL_USERS = "https://fakestoreapi.com/users";
    private final UserService userService;
    private final RestTemplate restTemplate;

    @Autowired
    public UserController(UserService userService, RestTemplate restTemplate) {
        this.userService = userService;
        this.restTemplate = restTemplate;
    }

    @GetMapping(path = "/users")
    public User getUser(@RequestParam Long id){

        final HashMap<String,Long> urlVariables = new HashMap<>();
//        urlVariables.put("id",id);
        final ResponseEntity<User[]> forEntity1 = restTemplate.getForEntity(
                URL_USERS,
                User[].class
        );

        return Arrays.stream(Objects.requireNonNull(forEntity1.getBody())).filter(user -> user.getId().equals(id)).findFirst().orElseThrow();
    }

}
