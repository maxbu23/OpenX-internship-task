package com.project.OpenXinternshiptask.constroller;

import com.project.OpenXinternshiptask.model.Product;
import com.project.OpenXinternshiptask.model.User;
import com.project.OpenXinternshiptask.service.ProductService;
import com.project.OpenXinternshiptask.service.UserService;
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
public class ProductController {

    final static String URL_PRODUCTS = "https://fakestoreapi.com/products";
    private final ProductService productService;
    private final RestTemplate restTemplate;

    @Autowired
    public ProductController(ProductService productService, RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    @GetMapping(path = "/products")
    public Product getUser(@RequestParam Long id){

        final HashMap<String,Long> urlVariables = new HashMap<>();
//        urlVariables.put("id",id);
        final ResponseEntity<Product[]> forEntity1 = restTemplate.getForEntity(
                URL_PRODUCTS,
                Product[].class
        );

        return Arrays.stream(Objects.requireNonNull(forEntity1.getBody())).filter(product -> product.getId().equals(id)).findFirst().orElseThrow();
    }
}
