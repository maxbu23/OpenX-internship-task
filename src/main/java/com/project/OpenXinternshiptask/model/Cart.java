package com.project.OpenXinternshiptask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Data
public class Cart {

    @Id
    private Long id;
    private Long userId;
    private ZonedDateTime date;
    @Embedded
    private List<ProductInCart> products;
    private Integer __v;

}

@Embeddable
class ProductInCart{

    @JsonProperty("productId")
    private Long productId;
    @JsonProperty("quantity")
    private Integer quantity;
}


