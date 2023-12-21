package com.capitole.ecommerce.price.rest.controller.response.mapper;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.capitole.ecommerce.price.Price;
import com.capitole.ecommerce.price.rest.interfaces.dto.ProductRest;

/**
 * Mapeador de objetos de dominio a objetos Rest
 * @author fjcastano
 */
@Component
public class ProductRestMapper {

	public ProductRest mapTo(Price source) {
		Objects.requireNonNull(source);
		return new ProductRest(source.getBrandId(), source.getProductId(), source.getFee(), source.getStartDate().atOffset(ZoneOffset.UTC),
				source.getEndDate().atOffset(ZoneOffset.UTC), source.getProductPrice());
	}

	public Collection<ProductRest> mapTo(Collection<Price> source) {
		Objects.requireNonNull(source);
		Collection<ProductRest> destinyCollection = new ArrayList<>();
		source.forEach(sourcePrice -> destinyCollection.add(this.mapTo(sourcePrice)));
		return destinyCollection;
	}

}
