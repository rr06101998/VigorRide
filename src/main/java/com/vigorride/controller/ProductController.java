package com.vigorride.controller;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vigorride.entity.Product;
import com.vigorride.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
		
	
	
	@PostMapping("/product")
	public boolean createProduct( @Valid @RequestBody  Product product ) {
		 return productService.createProduct(product);
	}
	
	@GetMapping("/{promotionId}/product")
	public List<Product> getAllProduct(@PathVariable("promotionId") String promotionId) {
		 return productService.getAllProduct(promotionId);
	}
	
	
	
}
