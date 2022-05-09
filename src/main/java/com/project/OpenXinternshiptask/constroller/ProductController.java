package com.project.OpenXinternshiptask.constroller;

import com.project.OpenXinternshiptask.model.product.Product;
import com.project.OpenXinternshiptask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ProductController {

    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/products")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Product getProductById(@RequestParam("id") Integer id){
        return this.productService.getProductById(id);
    }

    @GetMapping(path = "/products-category-and-total-values")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Map<String,Double> getProductsCategoryAndTheirsTotalValues(){
        return this.productService.getProductsCategoryAndTheirsTotalValues();
    }
}
