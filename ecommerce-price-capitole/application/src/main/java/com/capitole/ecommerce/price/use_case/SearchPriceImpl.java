package com.capitole.ecommerce.price.use_case;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.capitole.ecommerce.price.Price;
import com.capitole.ecommerce.price.exception.ProductoNotFoundException;
import com.capitole.ecommerce.price.repository.PriceRepository;

@Service
public class SearchPriceImpl implements SearchPrice {

	private final PriceRepository pricesRepository;

	@Inject
	public SearchPriceImpl(PriceRepository pricesRepository) {
		this.pricesRepository = pricesRepository;
	}

	@Override
	public Price findPriorityPriceByBrandProductAndDate(Integer brandId, Long productId, LocalDateTime selectedDate) {

		Objects.requireNonNull(brandId);
		Objects.requireNonNull(productId);
		Objects.requireNonNull(selectedDate);

		return this.pricesRepository.findPriorityPriceByBrandProductAndDate(brandId, productId, selectedDate).stream().findFirst()
				.orElseThrow(ProductoNotFoundException::new);
	}

}
