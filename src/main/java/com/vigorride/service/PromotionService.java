package com.vigorride.service;

import java.util.List;

import com.vigorride.entity.Promotion;

public interface PromotionService {
	
    public List<Promotion> getAllPromotion( );
    
	public boolean createPromotion(final Promotion  promotion);
	
}
