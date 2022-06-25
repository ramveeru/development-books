package com.ram.developmentbooks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ram.developmentbooks.model.Book;
import com.ram.developmentbooks.model.Cart;
import com.ram.developmentbooks.model.Item;
import com.ram.developmentbooks.serviceImpl.PriceServiceImpl;


public class PriceServiceTest {

	
	PriceServiceImpl priceService;
	public PriceServiceTest() {
		priceService=new PriceServiceImpl();
	}
	
	
	
	 	@Test
	    public void testNoDiscountForSingleBook(){
	        List<Item> itemsInCart = new ArrayList<Item>();
	        itemsInCart.add(new Item(new Book("a",50), 1));
			Cart cart = new Cart(itemsInCart);
			assertEquals(50, priceService.calculateTotalPrice(cart));
	    }
	 	@Test
	    public void testDiscountForTwoDifferentBook(){
	        List<Item> itemsInCart = new ArrayList<Item>();
	        itemsInCart.add(new Item(new Book("a",50), 1));
	        itemsInCart.add(new Item(new Book("b",50), 1));
			Cart cart = new Cart(itemsInCart);
			assertEquals(95, priceService.calculateTotalPrice(cart));
	    }
	 	@Test
	    public void testDiscountForThreeDifferentBook(){
	        List<Item> itemsInCart = new ArrayList<Item>();
	        itemsInCart.add(new Item(new Book("a",50), 1));
	        itemsInCart.add(new Item(new Book("b",50), 1));
	        itemsInCart.add(new Item(new Book("c",50), 1));
			Cart cart = new Cart(itemsInCart);
			assertEquals(135, priceService.calculateTotalPrice(cart));
	    }
	 	@Test
	    public void testDiscountForFourDifferentBook(){
	        List<Item> itemsInCart = new ArrayList<Item>();
	        itemsInCart.add(new Item(new Book("a",50), 1));
	        itemsInCart.add(new Item(new Book("b",50), 1));
	        itemsInCart.add(new Item(new Book("c",50), 1));
	        itemsInCart.add(new Item(new Book("d",50), 1));
			Cart cart = new Cart(itemsInCart);
			assertEquals(160, priceService.calculateTotalPrice(cart));
	    }
	 	@Test
	    public void testDiscountForFiveDifferentBook(){
	        List<Item> itemsInCart = new ArrayList<Item>();
	        itemsInCart.add(new Item(new Book("a",50), 1));
	        itemsInCart.add(new Item(new Book("b",50), 1));
	        itemsInCart.add(new Item(new Book("c",50), 1));
	        itemsInCart.add(new Item(new Book("d",50), 1));
	        itemsInCart.add(new Item(new Book("e",50), 1));
			Cart cart = new Cart(itemsInCart);
			assertEquals(187.5, priceService.calculateTotalPrice(cart));
	    }
	 	
	 	@Test
	    public void testNoDiscountForTwoSameBooks(){
			Cart cart = new Cart();
			cart.AddBook(new Book("a", 50));
			cart.AddBook(new Book("a", 50));
			assertEquals(100, priceService.calculateTotalPrice(cart));
	    }
	 	
	 	@Test
	    public void testDiscountForTwoSameBooksAndTwoUniqueBooks(){
			Cart cart = new Cart();
			cart.AddBook(new Book("a", 50));
			cart.AddBook(new Book("a", 50));
			cart.AddBook(new Book("b", 50));
			assertEquals(145, priceService.calculateTotalPrice(cart));
	    }
	 	@Test
	    public void testDiscountForTwoUniqueSetOfFourBooks(){
			Cart cart = new Cart();
			cart.AddBook(new Book("a", 50));
			cart.AddBook(new Book("a", 50));
			cart.AddBook(new Book("b", 50));
			cart.AddBook(new Book("b", 50));
			cart.AddBook(new Book("c", 50));
			cart.AddBook(new Book("c", 50));
			cart.AddBook(new Book("d", 50));
			cart.AddBook(new Book("e", 50));
			assertEquals(320, priceService.calculateTotalPrice(cart));
	    }
}
