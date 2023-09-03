package com.vigorride.product.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigorride.product.entity.ProductCategory;

@Service
public class ProductCategoryRepositoryWrapper {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public ProductCategory findByName(String name) {
        return this.productCategoryRepository.findByName(name);
    }

    public void save(ProductCategory productCategory) {
        this.productCategoryRepository.save(productCategory);
    }

    public Optional<ProductCategory> findById(Long categoryId) {
        return this.productCategoryRepository.findById(categoryId);
    }

}
