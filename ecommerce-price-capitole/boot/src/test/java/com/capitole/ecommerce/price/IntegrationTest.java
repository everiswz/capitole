package com.capitole.ecommerce.price;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void integrationTest_hour_10_day_14_product_35455() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/brand/{brandId}/product/{productId}/price", 1, 35455)
						.param("selectedDate", "2020-06-14T10:00:00Z").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(Double.valueOf("35.5")));
	}

	@Test
	void integrationTest_hour_16_day_14_product_35455() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/brand/{brandId}/product/{productId}/price", 1, 35455)
						.param("selectedDate", "2020-06-14T16:00:00Z").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(Double.valueOf("25.45")));
	}

	@Test
	void integrationTest_hour_21_day_14_product_35455() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/brand/{brandId}/product/{productId}/price", 1, 35455)
						.param("selectedDate", "2020-06-14T21:00:00Z").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(Double.valueOf("35.5")));
	}

	@Test
	void integrationTest_hour_10_day_15_product_35455() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/brand/{brandId}/product/{productId}/price", 1, 35455)
						.param("selectedDate", "2020-06-15T10:00:00Z").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(Double.valueOf("30.5")));
	}

	@Test
	void integrationTest_hour_21_day_16_product_35455() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/brand/{brandId}/product/{productId}/price", 1, 35455)
						.param("selectedDate", "2020-06-16T21:00:00Z").content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$.price").value(Double.valueOf("38.95")));
	}

}
