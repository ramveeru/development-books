package com.ram.developmentbooks.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

import com.ram.developmentbooks.model.Book;
import com.ram.developmentbooks.model.BookCombo;
import com.ram.developmentbooks.model.Cart;
import com.ram.developmentbooks.model.Item;
import com.ram.developmentbooks.service.PriceService;


@Service
public class PriceServiceImpl implements PriceService {
	
	Map<Integer, Integer> discounts = new HashMap<Integer, Integer>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{	put(1, 0);
			put(2, 5);
			put(3, 10);
			put(4, 20);
			put(5, 25);
		}
	};
	
	@Override
	public double calculateTotalPrice(Cart cart) {
		
	    double totalPrice =0;
        double comboPrice =0;
        
        List<BookCombo> bookSetWithMaxDisc = getbestCombinationBooks(cart.getItemsInCart());

        for (BookCombo bookCombo:bookSetWithMaxDisc){
            for (Book book:bookCombo.getBooks()) {
            	comboPrice += book.getRetailPrice();
            }

            comboPrice = comboPrice * (1.0 - (bookCombo.getDiscount()/100.0));
            totalPrice +=comboPrice;
            comboPrice = 0;
        }

        return totalPrice;
	}

	private List<BookCombo> getbestCombinationBooks(List<Item> itemsInCart) {
		
		List<List<BookCombo>> differentBooksCombinations = new ArrayList<>();
		
		for(int i= itemsInCart.size();i>=1;i--) {
			
			differentBooksCombinations.add(getBooksCombination(itemsInCart, i));
			
		}
		
		return getHighestDiscounts(differentBooksCombinations);
	}

	private List<BookCombo> getBooksCombination(List<Item> itemsInCart, int size) {
		List<Item> itemsInCartCopy =createDeepCopy(itemsInCart);
		List<BookCombo> bookscombos = new ArrayList<>();
		while (!itemsInCartCopy.isEmpty()) {
			BookCombo bookCombo = createCombinations(itemsInCartCopy, size);
			bookscombos.add(bookCombo);
		}
		return bookscombos;
	}

	private List<Item> createDeepCopy(List<Item> itemsInCart) {
		List<Item> itemsInCartCopy = new CopyOnWriteArrayList<>();
		for (Item item:itemsInCart) {
			itemsInCartCopy.add(new Item(item.getBook(), item.getQuantity()));
        }
		return itemsInCartCopy;

		
	}

	private BookCombo createCombinations(List<Item> itemsInCartCopy,int size) {
		  HashSet<Book> books = new HashSet<>();

	        for (Item item:itemsInCartCopy) {

	            books.add(item.getBook());
	            if (item.getQuantity() == 1) {
	            	itemsInCartCopy.remove(item);
	            }
	            else {
	                item.setQuantity(item.getQuantity() - 1);
	            }

	            if (books.size() == size) {
	                break;
	            }
	        }

	        BookCombo BookCombo = new BookCombo(books,discounts.get(books.size()));

	        return BookCombo;
	}
    private List<BookCombo> getHighestDiscounts(List<List<BookCombo>> BookSetsCombo) {
        List<BookCombo> highDiscountBookCombo = new ArrayList<BookCombo>();
        int highestDiscount = 0;
        int tempDiscount = 0;

        for (List<BookCombo> BookCombos:BookSetsCombo) {
            for (BookCombo BookCombo:BookCombos) {
            	tempDiscount += BookCombo.getDiscount();
            }

            if (highestDiscount <=tempDiscount) {
            	highDiscountBookCombo = BookCombos;
                highestDiscount = tempDiscount;
            }

            tempDiscount = 0;
        }

        return highDiscountBookCombo;
    }


}
