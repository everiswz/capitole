package com.capitole.ecommerce.price;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PRICES")
public class PriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRICE_ID", length = 9, nullable = false, unique = true)
	private Long id;

	@Column(name = "BRAND_ID", length = 1, nullable = false, unique = false)
	private Integer brandId;

	@Column(name = "PRODUCT_ID", length = 9, nullable = false, unique = false)
	private Long productId;

	@Column(name = "PRICE_LIST", length = 1, nullable = false, unique = false)
	private Integer fee;

	@CreationTimestamp
	@Column(name = "START_DATE", nullable = false, unique = false)
	private LocalDateTime startDate;

	@CreationTimestamp
	@Column(name = "END_DATE", nullable = false, unique = false)
	private LocalDateTime endDate;

	@Column(name = "PRIORITY", length = 1, nullable = false, unique = false)
	private Integer priority;

	@Column(name = "PRICE", nullable = false, unique = false)
	private Double price;

	@Column(name = "CURR", length = 3, nullable = false, unique = false)
	private String currency;

}
