package com.ram.developmentbooks.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DiscountRule {
	
	private int numberOfUniqueBooks;
	private int discount;

}
