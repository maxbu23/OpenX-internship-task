package com.project.OpenXinternshiptask.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @Id
    private Long id;
    private Long userId;
    private ZonedDateTime date;
    @Embedded
    private List<ProductInCart> products;
    private Integer __v;

}

