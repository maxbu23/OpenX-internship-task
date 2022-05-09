package com.project.OpenXinternshiptask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Geolocation {

    @JsonProperty("lat")
    private Double latitude;
    @JsonProperty("long")
    private Double longitude;
}
