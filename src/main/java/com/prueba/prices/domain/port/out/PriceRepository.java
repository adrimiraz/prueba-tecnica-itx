package com.prueba.prices.domain.port.out;

import java.time.LocalDateTime;
import java.util.Optional;

import com.prueba.prices.domain.model.Price;

public interface PriceRepository {
	Optional<Price> findApplicablePrice(LocalDateTime date, Long productId, Long brandId);
}
