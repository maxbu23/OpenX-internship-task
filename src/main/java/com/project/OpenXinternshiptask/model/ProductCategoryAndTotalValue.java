package com.project.OpenXinternshiptask.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCategoryAndTotalValue {

    private Category category;
    private Double totalValue;

    public enum Category{
        MEN_CLOTHING,
        JEWELERY,
        ELECTRONICS,
        WOMEN_CLOTHING
    }
}
