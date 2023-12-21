package com.capitole.ecommerce.price.repository.base;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capitole.ecommerce.price.PriceEntity;

@Repository
public interface BaseJpaRepository extends JpaRepository<PriceEntity, Long> {

	List<PriceEntity> findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(Integer brandId, Long productId,
			LocalDateTime selectedDateOne, LocalDateTime selectedDateTwo);

}
