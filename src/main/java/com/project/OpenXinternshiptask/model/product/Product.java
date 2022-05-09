package com.project.OpenXinternshiptask.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class Product {

    private Integer id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    @Embedded
    private Rating rating;
}



