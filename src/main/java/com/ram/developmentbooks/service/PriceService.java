package com.ram.developmentbooks.service;

import org.springframework.stereotype.Service;

import com.ram.developmentbooks.model.Cart;

@Service
public interface PriceService {
	
	
	double calculateTotalPrice(Cart cart);

}
