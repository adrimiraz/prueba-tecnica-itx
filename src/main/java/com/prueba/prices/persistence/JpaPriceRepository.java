package com.prueba.prices.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prueba.prices.persistence.entity.PriceEntity;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {

	Optional<PriceEntity> findTopByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
	        Long productId,
	        Long brandId,
	        LocalDateTime date1,
	        LocalDateTime date2
	    );
}