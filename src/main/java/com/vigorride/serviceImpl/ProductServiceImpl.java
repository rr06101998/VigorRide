package com.vigorride.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.vigorride.entity.Product;
import com.vigorride.repository.ProductRepository;
import com.vigorride.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;

	
	@Override
	public boolean createProduct(final Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
		return true;
	}

	@Override
	public List<Product> getAllProduct(final String promotionId) {
		// TODO Auto-generated method stub
		
		return productRepository.findByPromotionId(promotionId);
	}

}
