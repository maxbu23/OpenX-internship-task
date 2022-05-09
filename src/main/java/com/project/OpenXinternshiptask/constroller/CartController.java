package com.project.OpenXinternshiptask.constroller;

import com.project.OpenXinternshiptask.model.cart.Cart;
import com.project.OpenXinternshiptask.model.cart.HighestValueCartResponse;
import com.project.OpenXinternshiptask.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(path = "/carts")
    public Cart getUser(@RequestParam("id") Integer id) {
        return this.cartService.getCartById(id);
    }

    @GetMapping(path = "/cart-with-the-highest-value")
    public HighestValueCartResponse getCardWithTheHighestValue(){
        return this.cartService.findCartWithTheHighestValue();
    }
}
