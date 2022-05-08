package com.project.OpenXinternshiptask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Product {

    @Id
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    @Embedded
    private Rating rating;
}
@Embeddable
class Rating{
    @JsonProperty("rate")
    private Double rate;
    @JsonProperty("count")
    private Integer count;
}
