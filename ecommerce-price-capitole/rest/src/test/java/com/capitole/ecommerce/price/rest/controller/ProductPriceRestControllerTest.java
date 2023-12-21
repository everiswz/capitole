package com.capitole.ecommerce.price.rest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.capitole.ecommerce.price.Price;
import com.capitole.ecommerce.price.rest.controller.response.mapper.ProductRestMapper;
import com.capitole.ecommerce.price.rest.interfaces.dto.ProductRest;
import com.capitole.ecommerce.price.use_case.SearchPrice;

@ExtendWith(MockitoExtension.class)
class ProductPriceRestControllerTest {

	@InjectMocks
	private ProductPriceRestController productPriceRestController;

	@Mock
	private SearchPrice searchPrice;

	@Mock
	private ProductRestMapper mapper;

	@Test
	void findProduct_ok() {

		when(this.searchPrice.findPriorityPriceByBrandProductAndDate(Mockito.anyInt(), Mockito.anyLong(), Mockito.any()))
				.thenReturn(Price.maker().build());
		when(this.mapper.mapTo(Mockito.any(Price.class))).thenReturn(new ProductRest());

		ResponseEntity<ProductRest> reponse = this.productPriceRestController.findProductWithPriorityPriceByBrandProductAndDate(1, 1L,
				OffsetDateTime.now());
		assertNotNull(reponse);
		assertEquals(HttpStatusCode.valueOf(200), reponse.getStatusCode());
		assertNotNull(reponse.getBody());
	}

}
