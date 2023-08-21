package com.vigorride.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vigorride.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByPromotionId(String promotionId);

}
