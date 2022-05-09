package com.project.OpenXinternshiptask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInCart{

    @JsonProperty("productId")
    private Long productId;
    @JsonProperty("quantity")
    private Integer quantity;
}