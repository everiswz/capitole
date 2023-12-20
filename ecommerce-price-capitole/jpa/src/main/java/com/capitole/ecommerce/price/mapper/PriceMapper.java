package com.capitole.ecommerce.price.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.capitole.ecommerce.price.Price;
import com.capitole.ecommerce.price.PriceEntity;

/**
 * Mapper from entity PriceEntity to domain Price
 * @author fjcastano
 */
@Component
public class PriceMapper {

	public Collection<Price> mapTo(Collection<PriceEntity> sourceCollection) {

		if (Objects.isNull(sourceCollection) || sourceCollection.isEmpty()) {
			return Collections.emptyList();
		}

		Collection<Price> result = new ArrayList<>();
		sourceCollection.forEach(priceEntity -> result.add(this.mapTo(priceEntity)));
		return result;
	}

	public Price mapTo(PriceEntity source) {

		return Price.maker().domainId(source.getId()).brandId(source.getBrandId()).productId(source.getProductId()).fee(source.getFee())
				.currency(source.getCurrency()).endDate(source.getEndDate()).price(source.getPrice()).priority(source.getPriority())
				.startDate(source.getStartDate()).build();

	}

}
