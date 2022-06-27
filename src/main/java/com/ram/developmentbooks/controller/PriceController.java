package com.ram.developmentbooks.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.developmentbooks.model.Cart;
import com.ram.developmentbooks.service.PriceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Tag(name = "PriceController", description = "an api to calculate the final book price after discount")
public class PriceController {

	@NonNull
	private PriceService priceService;

	@Operation(summary = "calculate book price after discount", responses = {
			@ApiResponse(responseCode = "400", description = "Bad Request - Unformatted Request JSON") })
	@PostMapping(path = "/price", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> getPrice(@RequestBody Cart cart) {

		return new ResponseEntity<Double>(priceService.calculateTotalPrice(cart), HttpStatus.OK);

	}
}