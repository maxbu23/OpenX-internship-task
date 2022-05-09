package com.project.OpenXinternshiptask.service;

import com.project.OpenXinternshiptask.model.Cart;
import com.project.OpenXinternshiptask.model.HighestValueCartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Objects;

@Service
public class CartService {

    final static String URL_CARTS = "https://fakestoreapi.com/carts";
    private final RestTemplate restTemplate;
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public CartService(RestTemplate restTemplate, ProductService productService, UserService userService) {
        this.restTemplate = restTemplate;
        this.productService = productService;
        this.userService = userService;
    }

    public Cart getCartById(Long id) {
        return Arrays
                .stream(Objects.requireNonNull(getCartsArray()))
                .filter(cart -> cart.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public HighestValueCartResponse findCardWithTheHighestValue() {

        final Cart[] cartsArray = getCartsArray();
        double totalValue = 0;
        Long userIdWithMaxValueableCart = 1L;
        double maxValue = 0;
        Cart cartWithMaxValue = getCartById(1L);

        for (Cart cart : cartsArray) {
            totalValue += cart.getProducts()
                    .stream()
                    .map(productInCart
                            -> productInCart.getQuantity() * productService
                            .getProductById(productInCart.getProductId())
                            .getPrice())
                    .reduce(0.0, Double::sum);

            if (totalValue > maxValue) {
                cartWithMaxValue = cart;
                maxValue = totalValue;
                userIdWithMaxValueableCart = cart.getUserId();
            }
        }

        return new HighestValueCartResponse(
                cartWithMaxValue,
                maxValue,
                userService.getUserById(userIdWithMaxValueableCart)
        );
    }

    private Cart[] getCartsArray() {
        return restTemplate.getForEntity(
                URL_CARTS,
                Cart[].class
        ).getBody();
    }

}