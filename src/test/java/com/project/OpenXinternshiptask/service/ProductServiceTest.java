package com.project.OpenXinternshiptask.service;

import com.project.OpenXinternshiptask.model.product.Product;
import com.project.OpenXinternshiptask.model.product.Rating;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductServiceTest {

    private ProductService underTest;

    @BeforeEach
    public void setUp(){
        RestTemplate restTemplate = new RestTemplate();
        List<Product> products = generateTestData();
        underTest = new ProductService(restTemplate,products);
    }

    @Test
    public void shouldGetProductsCategoryAndTheirTotalValues(){
        // given
        Map<String,Double> expected = Map.of(
                "category1",123.2+109.3,
                "category2",232.4+998.0
        );

        // when
        final Map<String, Double> result = underTest.getProductsCategoryAndTheirsTotalValues();

        // then
        assertThat(expected).isEqualTo(result);
    }

    @Test
    public void shouldGetProductBy(){
        // given
        final Product expected = new Product(2,
                "title2",
                232.4,
                "description2",
                "category2",
                "image2",
                new Rating( 7.6D,9));
        Integer id = 2;

        //when
        final Product result = underTest.getProductById(id);

        // then
        assertThat(expected).isEqualTo(result);
    }

    private List<Product> generateTestData(){
        return List.of(
                new Product(
                        1,
                        "title0",
                        123.2,
                        "description1",
                        "category1",
                        "image1",
                        new Rating( 8.1D,2)
                ),
                new Product(
                        2,
                        "title2",
                        232.4,
                        "description2",
                        "category2",
                        "image2",
                        new Rating( 7.6D,9)
                ),
                new Product(
                        3,
                        "title2",
                        998.0,
                        "description2",
                        "category2",
                        "image1",
                        new Rating( 8.1D,2)
                ),
                new Product(
                        4,
                        "title2",
                        109.3,
                        "description2",
                        "category1",
                        "image1",
                        new Rating( 8.1D,2)
                )
        );
    }
}
