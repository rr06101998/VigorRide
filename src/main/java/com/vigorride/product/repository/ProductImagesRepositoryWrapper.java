package com.vigorride.product.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigorride.product.entity.ProductImages;

@Service
public class ProductImagesRepositoryWrapper {
    @Autowired
    private ProductImagesRepository productImagesRepository;

    public void saveAll(List<ProductImages> productImages) {
        this.productImagesRepository.saveAll(productImages);
    }
    
}
