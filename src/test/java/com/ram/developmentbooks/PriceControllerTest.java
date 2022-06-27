package com.ram.developmentbooks;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ram.developmentbooks.model.Book;
import com.ram.developmentbooks.model.Cart;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerTest {

	@Autowired
	private MockMvc mockMvc;


	
		
	
	@Test
	public void shouldReturnValidDiscount() throws Exception {
		Cart cart = new Cart();
		cart.AddBook(new Book("a", 50));
		cart.AddBook(new Book("a", 50));
		cart.AddBook(new Book("b", 50));
		cart.AddBook(new Book("b", 50));
		cart.AddBook(new Book("c", 50));
		cart.AddBook(new Book("c", 50));
		cart.AddBook(new Book("d", 50));
		cart.AddBook(new Book("e", 50));
		this.mockMvc.perform(post("/price").contentType(MediaType.APPLICATION_JSON_VALUE).content(asJsonString(cart))).andDo(print())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().is2xxSuccessful()).andExpect(content().string("320.0"));
		
	}
	
	@Test
	public void shouldReturnError() throws Exception {
		this.mockMvc.perform(post("/price").contentType(MediaType.APPLICATION_JSON_VALUE).content("test")).andDo(print())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().is4xxClientError());
						}
	public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
