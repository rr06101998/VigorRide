package com.vigorride.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vigorride.product.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{

    ProductCategory findByName(String name);

}
