package com.project.OpenXinternshiptask.service;

import com.project.OpenXinternshiptask.model.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@AllArgsConstructor
public class ProductService {

    final static String URL_PRODUCTS = "https://fakestoreapi.com/products";
    private final RestTemplate restTemplate;
    private final List<Product> products;

    @Autowired
    public ProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.products = Arrays.stream(getAllProducts()).toList();
    }

    private Product[] getAllProducts() {
        return restTemplate.getForEntity(
                URL_PRODUCTS,
                Product[].class
        ).getBody();
    }

    public Product getProductById(@RequestParam Integer id) {
        //index of List is associated with index+1 of our product object, so requested id we need to decrement to get appropriate object from list
        return this.products.get(id-1);
    }

    public Map<String,Double> getProductsCategoryAndTheirsTotalValues(){

        Map<String,Double> categoriesAndValue = new HashMap<>();
        for(Product product: products){
            String category = product.getCategory();
            Double value = product.getPrice();
            if(categoriesAndValue.containsKey(category))
                categoriesAndValue.put(category,categoriesAndValue.get(category)+value);
            else
                categoriesAndValue.put(category,value);
        }



        return categoriesAndValue;
    }


}
