package com.project.OpenXinternshiptask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Embeddable
public class Address {

    @JsonProperty("geolocation")
    private Geolocation geolocation;
    @JsonProperty("city")
    private String city;
    @JsonProperty("street")
    private String street;
    @JsonProperty("number")
    private Long number;
    @JsonProperty("zipcode")
    private String zipCode;
}

@Embeddable
class Geolocation{

    @JsonProperty("lat")
    private String latitude;
    @JsonProperty("long")
    private String longitude;
}