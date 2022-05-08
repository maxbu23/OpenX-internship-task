package com.project.OpenXinternshiptask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
public class User {

    @Id
    private Long id;
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

@Embeddable
class Name{
    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("lastname")
    private String lastName;
}
