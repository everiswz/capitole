package com.capitole.ecommerce.price.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capitole.ecommerce.price.Price;
import com.capitole.ecommerce.price.PriceEntity;

@ExtendWith(MockitoExtension.class)
class PriceMapperTest {

	@Test
	void mapTo_SingleOk() {

		PriceEntity priceEntity = this.createPriceEntity();
		Price price = new PriceMapper().mapTo(priceEntity);

		assertNotNull(price);
		assertEquals(priceEntity.getBrandId(), price.getBrandId());
		assertEquals(priceEntity.getCurrency(), price.getCurrency());
		assertEquals(priceEntity.getEndDate(), price.getEndDate());
		assertEquals(priceEntity.getFee(), price.getFee());
		assertEquals(priceEntity.getId(), price.getDomainId());
		assertEquals(priceEntity.getPrice(), price.getProductPrice());
		assertEquals(priceEntity.getPriority(), price.getPriority());
		assertEquals(priceEntity.getStartDate(), price.getStartDate());
	}

	@Test
	void mapTo_CollectionOk() {
		Collection<Price> priceCollection = new PriceMapper().mapTo(Collections.singletonList(this.createPriceEntity()));
		assertNotNull(priceCollection);
		assertEquals(1, priceCollection.size());
	}

	@Test
	void mapTo_CollectionEmpty() {
		assertEquals(0, new PriceMapper().mapTo(Collections.emptyList()).size());
	}

	private PriceEntity createPriceEntity() {
		PriceEntity priceEntity = new PriceEntity();
		priceEntity.setBrandId(1);
		priceEntity.setCurrency("EUR");
		priceEntity.setEndDate(LocalDateTime.now());
		priceEntity.setFee(1);
		priceEntity.setId(1L);
		priceEntity.setPrice(35.5);
		priceEntity.setPriority(1);
		priceEntity.setProductId(1L);
		priceEntity.setStartDate(LocalDateTime.now());

		return priceEntity;
	}

}
