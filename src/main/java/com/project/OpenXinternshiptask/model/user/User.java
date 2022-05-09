package com.project.OpenXinternshiptask.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("email")
    private String email;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("name")
    private Name name;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("__v")
    private Integer __v;
}


