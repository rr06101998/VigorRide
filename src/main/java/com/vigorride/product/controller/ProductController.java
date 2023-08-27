package com.vigorride.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vigorride.commons.constants.VigorRideConstants;
import com.vigorride.product.data.CreateProductCategoryPayload;
import com.vigorride.product.data.CreateProductPayload;
import com.vigorride.product.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(VigorRideConstants.VIGORRIDE_BASE_URL + "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create/category")
    public String createProductCategory(@Valid @RequestBody CreateProductCategoryPayload createProductCategoryPayload) {
        return productService.createProductCategory(createProductCategoryPayload);
    }

    @PostMapping("/create")
    public String createProduct(@Valid @RequestBody CreateProductPayload createProductPayload) {
        return productService.createProduct(createProductPayload);
    }

}
