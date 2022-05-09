package com.project.OpenXinternshiptask.constroller;

import com.project.OpenXinternshiptask.model.user.User;
import com.project.OpenXinternshiptask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public User getUser(@RequestParam("id") Integer id){
        return this.userService.getUserById(id);
    }

    @GetMapping(path = "/two-furthers-users")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public List<User> getTwoFurthersUser(){
        return this.userService.getTwoFurthersUsers();
    }
}
