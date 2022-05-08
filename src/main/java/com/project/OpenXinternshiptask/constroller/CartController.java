package com.project.OpenXinternshiptask.constroller;

import com.project.OpenXinternshiptask.model.Cart;
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
    final static String URL_CARTS = "https://fakestoreapi.com/carts";
    private final CartService cartService;
    private final RestTemplate restTemplate;

    @Autowired
    public CartController(CartService cartService, RestTemplate restTemplate) {
        this.cartService = cartService;
        this.restTemplate = restTemplate;
    }


    @GetMapping(path = "/carts")
    public Cart getUser(@RequestParam Long id) {

        final HashMap<String, Long> urlVariables = new HashMap<>();
//        urlVariables.put("id",id);
        final ResponseEntity<Cart[]> forEntity1 = restTemplate.getForEntity(
                URL_CARTS,
                Cart[].class
        );

        return Arrays.stream(Objects.requireNonNull(forEntity1.getBody())).filter(cart -> cart.getId().equals(id)).findFirst().orElseThrow();
    }
}
