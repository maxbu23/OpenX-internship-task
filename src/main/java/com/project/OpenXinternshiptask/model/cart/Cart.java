package com.project.OpenXinternshiptask.model.cart;

import com.project.OpenXinternshiptask.model.product.ProductInCart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private Integer id;
    private Integer userId;
    private ZonedDateTime date;
    @Embedded
    private List<ProductInCart> products;
    private Integer __v;

}

