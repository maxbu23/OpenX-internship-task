package com.project.OpenXinternshiptask.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HighestValueCartResponse {

    private Cart cart;
    private Double totalValue;
    private User user;
}
