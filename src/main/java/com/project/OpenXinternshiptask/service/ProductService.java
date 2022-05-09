package com.project.OpenXinternshiptask.service;

import com.project.OpenXinternshiptask.model.Cart;
import com.project.OpenXinternshiptask.model.Product;
import com.project.OpenXinternshiptask.model.ProductCategoryAndTotalValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static com.project.OpenXinternshiptask.model.ProductCategoryAndTotalValue.Category.*;

@Service
public class ProductService {

    final static String URL_PRODUCTS = "https://fakestoreapi.com/products";
    private final RestTemplate restTemplate;

    @Autowired
    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product getProductById(@RequestParam Long id) {

        final ResponseEntity<Product[]> forEntity1 = restTemplate.getForEntity(
                URL_PRODUCTS,
                Product[].class
        );

        return Arrays.stream(Objects.requireNonNull(forEntity1.getBody())).filter(product -> product.getId().equals(id)).findFirst().orElseThrow();

    }

    public List<ProductCategoryAndTotalValue> getProductsCategoryAndTheirsTotalValues(){
        final ProductCategoryAndTotalValue menClothing = new ProductCategoryAndTotalValue(MEN_CLOTHING, 0D);
        final ProductCategoryAndTotalValue jewelery = new ProductCategoryAndTotalValue(JEWELERY, 0D);
        final ProductCategoryAndTotalValue electronics = new ProductCategoryAndTotalValue(ELECTRONICS, 0D);
        final ProductCategoryAndTotalValue womenClothing = new ProductCategoryAndTotalValue(WOMEN_CLOTHING, 0D);
        for(Product product: getProductsArray()){
            switch (product.getCategory()) {
                case "men's clothing" -> menClothing.setTotalValue(menClothing.getTotalValue() + product.getPrice());
                case "jewelery" -> jewelery.setTotalValue(jewelery.getTotalValue() + product.getPrice());
                case "electronics" -> electronics.setTotalValue(electronics.getTotalValue() + product.getPrice());
                case "women's clothing" -> womenClothing.setTotalValue(womenClothing.getTotalValue() + product.getPrice());
            }
        }

        return List.of(
                menClothing,
                jewelery,
                electronics,
                womenClothing
        );
    }

    private Product[] getProductsArray() {
        return restTemplate.getForEntity(
                URL_PRODUCTS,
                Product[].class
        ).getBody();
    }
}
