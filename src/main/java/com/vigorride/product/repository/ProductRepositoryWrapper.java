package com.vigorride.product.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigorride.product.entity.Product;

@Service
public class ProductRepositoryWrapper {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return this.productRepository.save(product);
    }
    
}
