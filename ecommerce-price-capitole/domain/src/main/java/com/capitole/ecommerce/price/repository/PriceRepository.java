package com.capitole.ecommerce.price.repository;

import java.time.LocalDateTime;
import java.util.Collection;

import com.capitole.ecommerce.price.Price;

public interface PriceRepository {

	Collection<Price> findByBrandProductAndDate(Integer brandId, Long productId, LocalDateTime selectedDate);

}
