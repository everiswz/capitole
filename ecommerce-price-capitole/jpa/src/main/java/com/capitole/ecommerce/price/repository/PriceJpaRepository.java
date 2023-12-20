package com.capitole.ecommerce.price.repository;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.capitole.ecommerce.price.Price;
import com.capitole.ecommerce.price.mapper.PriceMapper;
import com.capitole.ecommerce.price.repository.base.BaseJpaRepository;

@Repository
public class PriceJpaRepository implements PriceRepository {

	private final BaseJpaRepository repository;
	private final PriceMapper mapper;

	@Inject
	public PriceJpaRepository(BaseJpaRepository repository, PriceMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Collection<Price> findByBrandProductAndDate(Integer brandId, Long productId, LocalDateTime selectedDate) {
		return this.mapper.mapTo(this.repository.findByBrandIdAndProductIdAndStartDateGreaterThanEqualAndEndDateLessThanEqual(brandId, productId,
				selectedDate, selectedDate));
	}

}
