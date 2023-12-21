package com.capitole.ecommerce.price.rest.controller;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.capitole.ecommerce.price.rest.controller.response.mapper.ProductRestMapper;
import com.capitole.ecommerce.price.rest.interfaces.BrandApi;
import com.capitole.ecommerce.price.rest.interfaces.dto.ProductRest;
import com.capitole.ecommerce.price.use_case.SearchPrice;

/**
 * Implementa el controller generado por OpenApi
 * @author fjcastano
 */
@RestController
public class ProductPriceRestController implements BrandApi {

	private final SearchPrice searchPrice;
	private final ProductRestMapper mapper;

	@Inject
	public ProductPriceRestController(SearchPrice searchPrice, ProductRestMapper mapper) {
		this.searchPrice = searchPrice;
		this.mapper = mapper;
	}

	@Override
	public ResponseEntity<ProductRest> findProductWithPriorityPriceByBrandProductAndDate(Integer brandId, Long productId,
			OffsetDateTime selectedDate) {

		Objects.requireNonNull(brandId);
		Objects.requireNonNull(productId);
		Objects.requireNonNull(selectedDate);

		return ResponseEntity
				.ok(this.mapper.mapTo(this.searchPrice.findPriorityPriceByBrandProductAndDate(brandId, productId, selectedDate.toLocalDateTime())));
	}

}
