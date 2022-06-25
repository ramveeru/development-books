package com.ram.developmentbooks.model;

import java.util.HashSet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


	@Getter
	@Setter
	@AllArgsConstructor
	public class BookCombo {
	    private HashSet<Book> books;
	    private int discount;

}
