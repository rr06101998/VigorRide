package com.vigorride.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vigorride.entity.Promotion;
import com.vigorride.repository.PromotionRepository;
import com.vigorride.service.PromotionService;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor
public class PromotionServiceImpl implements PromotionService {
	
	private final PromotionRepository promotionRepository;

	@Override
	public List<Promotion> getAllPromotion() {
		// TODO Auto-generated method stub
		return promotionRepository.findAll();
	}

	@Override
	public boolean createPromotion(Promotion promotion) {
		// TODO Auto-generated method stub
		promotionRepository.save(promotion);
		return true;
		
	}

}
