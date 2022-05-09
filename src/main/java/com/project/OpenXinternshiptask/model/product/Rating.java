package com.project.OpenXinternshiptask.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Rating{
    @JsonProperty("rate")
    private Double rate;
    @JsonProperty("count")
    private Integer count;
}