package com.vigorride.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vigorride.entity.Promotion;
import com.vigorride.service.PromotionService;

import jakarta.validation.Valid;

@RestController
public class PromotionController {

	@Autowired
	private PromotionService promotionService;
		
	
	
	@PostMapping("/promotion")
	public boolean createPromotion( @Valid @RequestBody  Promotion promotion ) {
		 return promotionService.createPromotion(promotion);
	}
	
	@GetMapping("/promotion")
	public List<Promotion> getAllPromotions() {
		 return promotionService.getAllPromotion();
	}
	
	
	
}
