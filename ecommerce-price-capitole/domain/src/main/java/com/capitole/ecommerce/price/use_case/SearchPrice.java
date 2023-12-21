package com.capitole.ecommerce.price.use_case;

import java.time.LocalDateTime;

import com.capitole.ecommerce.price.Price;

public interface SearchPrice {

	Price findPriorityPriceByBrandProductAndDate(Integer brandId, Long productId, LocalDateTime selectedDate);

}
