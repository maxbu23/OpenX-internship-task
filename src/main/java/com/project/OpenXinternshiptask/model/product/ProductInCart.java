package com.project.OpenXinternshiptask.model.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInCart{

    @JsonProperty("productId")
    private Integer productId;
    @JsonProperty("quantity")
    private Integer quantity;
}