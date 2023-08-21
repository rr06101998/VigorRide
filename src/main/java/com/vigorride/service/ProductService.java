package com.vigorride.service;

import java.util.List;

import com.vigorride.entity.Product;
import com.vigorride.entity.Promotion;

import jakarta.validation.Valid;

public interface ProductService {

	public boolean createProduct(final Product product);
	public List<Product> getAllProduct(final String promotionId);
	

}
