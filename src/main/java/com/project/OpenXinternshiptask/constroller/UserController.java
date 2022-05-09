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
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public User getUser(@RequestParam Long id){

        return this.userService.getUserById(id);
    }

    @GetMapping(path = "/two-furthers-users")
    public List<User> getTwoFurthersUser(){
        return this.userService.getTwoFurthersUser();
    }
}
