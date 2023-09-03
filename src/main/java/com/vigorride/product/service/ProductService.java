package com.vigorride.product.service;

import com.vigorride.product.data.CreateProductCategoryPayload;
import com.vigorride.product.data.CreateProductPayload;

public interface ProductService {

    public String createProductCategory(CreateProductCategoryPayload createProductCategoryPayload);

    public String createProduct(CreateProductPayload createProductPayload);


}
