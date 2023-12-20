package com.capitole.ecommerce.price.rest.controller;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capitole.ecommerce.price.Price;
import com.capitole.ecommerce.price.use_case.SearchPrice;

@RestController
public class PriceRestController {

	private final SearchPrice searchPrice;

	@Inject
	public PriceRestController(SearchPrice searchPrice) {
		this.searchPrice = searchPrice;
	}

	@GetMapping("/test1")
	public Collection<Price> test() {

		return this.searchPrice.searchPrices();
	}

}
