package com.project.OpenXinternshiptask.constroller;

import com.project.OpenXinternshiptask.model.Product;
import com.project.OpenXinternshiptask.model.ProductCategoryAndTotalValue;
import com.project.OpenXinternshiptask.model.User;
import com.project.OpenXinternshiptask.service.ProductService;
import com.project.OpenXinternshiptask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class ProductController {

    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/products")
    public Product getProductById(@RequestParam Long id){
        return this.productService.getProductById(id);
    }

    @GetMapping(path = "/products-category-and-total-values")
    public List<ProductCategoryAndTotalValue> getProductsCategoryAndTheirsTotalValues(){
        return this.productService.getProductsCategoryAndTheirsTotalValues();
    }
}
