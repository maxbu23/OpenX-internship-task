package com.project.OpenXinternshiptask.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    private Integer id;
    @Embedded
    @JsonProperty("address")
    private Address address;
    private String email;
    private String username;
    private String password;
    @Embedded
    private Name name;
    private String phone;
    private Integer __v;
}


