package com.prueba.prices.application.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prueba.prices.domain.model.Price;
import com.prueba.prices.domain.port.out.PriceRepository;

@Service
public class PriceService {

	private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<Price> getPrice(LocalDateTime date, Long productId, Long brandId) {
        return priceRepository.findApplicablePrice(date, productId, brandId);
    }
	
}
