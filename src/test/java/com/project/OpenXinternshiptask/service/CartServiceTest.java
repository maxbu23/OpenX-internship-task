package com.project.OpenXinternshiptask.service;

import com.project.OpenXinternshiptask.model.cart.Cart;
import com.project.OpenXinternshiptask.model.cart.HighestValueCartResponse;
import com.project.OpenXinternshiptask.model.product.Product;
import com.project.OpenXinternshiptask.model.product.ProductInCart;
import com.project.OpenXinternshiptask.model.product.Rating;
import com.project.OpenXinternshiptask.model.user.Address;
import com.project.OpenXinternshiptask.model.user.Geolocation;
import com.project.OpenXinternshiptask.model.user.Name;
import com.project.OpenXinternshiptask.model.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CartServiceTest {

    private CartService underTest;


    @BeforeEach
    public void setUp(){
        RestTemplate restTemplate = new RestTemplate();
        List<Cart> carts = generateCartTestData();

        ProductService productService = new ProductService(restTemplate);
        UserService userService  = new UserService(restTemplate);
        underTest = new CartService(restTemplate,productService,userService,carts);
    }

    @Test
    public void shouldGetCartById(){
        // given
        final Cart expected = new Cart(2,
                3,
                ZonedDateTime.parse("2022-03-23T06:39:51-01:00"),
                List.of(
                        new ProductInCart(
                                2,
                                2
                        ),
                        new ProductInCart(
                                2,
                                9
                        )),
                1
        );
        Integer id = 2;

        // when
        final Cart result = underTest.getCartById(id);

        // then
        assertThat(expected).isEqualTo(result);
    }


    private List<Cart> generateCartTestData(){
        return List.of(
                new Cart(
                        1,
                        2,
                        ZonedDateTime.parse("2022-07-31T06:39:51-02:00"),
                        List.of(
                            new ProductInCart(
                                    3,
                                    1
                            ),
                            new ProductInCart(
                                    1,
                                    7
                            )),
                        2
                ),
                new Cart(
                        2,
                        3,
                        ZonedDateTime.parse("2022-03-23T06:39:51-01:00"),
                        List.of(
                                new ProductInCart(
                                        2,
                                        2
                                ),
                                new ProductInCart(
                                        2,
                                        9
                                )),
                        1
                ),
                new Cart(
                        3,
                        1,
                        ZonedDateTime.parse("2022-02-27T18:39:51-02:00"),
                        List.of(
                                new ProductInCart(
                                        3,
                                        5
                                ),
                                new ProductInCart(
                                        2,
                                        9
                                )),
                        1
                )
        );
    }
}
