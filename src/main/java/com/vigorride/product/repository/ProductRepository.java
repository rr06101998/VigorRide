package com.vigorride.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vigorride.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
