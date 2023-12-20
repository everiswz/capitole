package com.capitole.ecommerce.price;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Builder(builderMethodName = "maker")
@Getter
public class Price {

	private Long domainId;
	private Integer brandId;
	private Long productId;
	private Integer fee;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Integer priority;
	private Double price;
	private String currency;

}
