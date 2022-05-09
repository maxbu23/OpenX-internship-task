package com.project.OpenXinternshiptask.constroller;

import com.project.OpenXinternshiptask.model.Cart;
import com.project.OpenXinternshiptask.model.HighestValueCartResponse;
import com.project.OpenXinternshiptask.model.Product;
import com.project.OpenXinternshiptask.service.CartService;
import com.project.OpenXinternshiptask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

@RestController
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(path = "/carts")
    public Cart getUser(@RequestParam("id") Long id) {
        return this.cartService.getCartById(id);
    }

    @GetMapping(path = "/cart-with-the-highest-value")
    public HighestValueCartResponse getCardWithTheHighestValue(){
        return this.cartService.findCardWithTheHighestValue();
    }
}
