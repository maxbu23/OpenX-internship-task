package com.project.OpenXinternshiptask.service;

import com.project.OpenXinternshiptask.model.cart.Cart;
import com.project.OpenXinternshiptask.model.cart.HighestValueCartResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class CartService {

    final static String URL_CARTS = "https://fakestoreapi.com/carts";
    private final RestTemplate restTemplate;
    private final ProductService productService;
    private final UserService userService;
    private final List<Cart> carts;

    @Autowired
    public CartService(RestTemplate restTemplate, ProductService productService, UserService userService) {
        this.restTemplate = restTemplate;
        this.productService = productService;
        this.userService = userService;
        this.carts = Arrays.stream(getAllCarts()).toList();
    }

    private Cart[] getAllCarts() {
        return restTemplate.getForEntity(
                URL_CARTS,
                Cart[].class
        ).getBody();
    }

    public Cart getCartById(Integer id) {
        //index of List is associated with index+1 of our cart object, so requested id we need to decrement to get appropriate object from list
        return this.carts.get(id-1);
    }

    public HighestValueCartResponse findCartWithTheHighestValue() {

        double totalValue = 0;
        Integer userIdWithMaxValueableCart = 1;
        double maxValue = 0;
        Cart cartWithMaxValue = getCartById(1);

        for (Cart cart : carts) {
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
            totalValue = 0;
        }

        return new HighestValueCartResponse(
                maxValue,
                cartWithMaxValue,
                userService.getUserById(userIdWithMaxValueableCart).getName()
        );
    }
}