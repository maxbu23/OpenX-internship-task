package com.project.OpenXinternshiptask.model.cart;

import com.project.OpenXinternshiptask.model.cart.Cart;
import com.project.OpenXinternshiptask.model.user.Name;
import com.project.OpenXinternshiptask.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HighestValueCartResponse {

    private Double totalValue;
    private Cart cart;
    private Name name;
}
