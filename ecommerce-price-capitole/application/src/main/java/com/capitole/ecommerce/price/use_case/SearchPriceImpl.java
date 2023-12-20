package com.capitole.ecommerce.price.use_case;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.capitole.ecommerce.price.Price;
import com.capitole.ecommerce.price.repository.PriceRepository;

@Service
public class SearchPriceImpl implements SearchPrice {

	private final PriceRepository pricesRepository;

	@Inject
	public SearchPriceImpl(PriceRepository pricesRepository) {
		this.pricesRepository = pricesRepository;
	}

	@Override
	public Collection<Price> searchPrices() {
		return this.pricesRepository.findByBrandProductAndDate(1, Long.valueOf(35455), LocalDateTime.now());
	}

}
