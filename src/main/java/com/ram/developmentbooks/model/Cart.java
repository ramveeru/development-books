package com.ram.developmentbooks.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

	List<Item> itemsInCart = new ArrayList<Item>();

	public void AddBook(Book book) {

		Optional<Item> cartItem = itemsInCart.stream().filter(item -> item.getBook().getName().equals(book.getName()))
				.findFirst();

		if (cartItem.isPresent()) {
			cartItem.get().setQuantity(cartItem.get().getQuantity() + 1);
		} else {
			itemsInCart.add(new Item(book, 1));
		}

	}

}
