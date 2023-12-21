package com.capitole.ecommerce.price.rest.controller.response.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capitole.ecommerce.price.Price;
import com.capitole.ecommerce.price.rest.interfaces.dto.ProductRest;

@ExtendWith(MockitoExtension.class)
class ProductRestMapperTest {

	@Test
	void mapTo_Ok() {
		Price price = this.createPrice();
		ProductRest productRest = new ProductRestMapper().mapTo(price);
		assertNotNull(productRest);
		assertEquals(price.getBrandId(), productRest.getBrandId());
		assertEquals(price.getEndDate(), productRest.getEndDate().toLocalDateTime());
		assertEquals(price.getFee(), productRest.getFee());
		assertEquals(price.getProductPrice(), productRest.getPrice());
		assertEquals(price.getProductId(), productRest.getProductId());
		assertEquals(price.getStartDate(), productRest.getStartDate().toLocalDateTime());
	}

	private Price createPrice() {
		return Price.maker().brandId(1).currency("EUR").domainId(1L).endDate(LocalDateTime.now()).fee(1).priority(1).productId(1L).productPrice(10.1)
				.startDate(LocalDateTime.now()).build();
	}

}
