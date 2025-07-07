package com.prueba.prices.config;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.prueba.prices.persistence.JpaPriceRepository;
import com.prueba.prices.persistence.entity.PriceEntity;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final JpaPriceRepository repository;

    public DataInitializer(JpaPriceRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void loadData() {
        repository.save(createPrice(1L, 35455L, 1, 0, new BigDecimal("35.50"),
                "EUR", "2020-06-14T00:00:00", "2020-12-31T23:59:59"));

        repository.save(createPrice(1L, 35455L, 2, 1, new BigDecimal("25.45"),
                "EUR", "2020-06-14T15:00:00", "2020-06-14T18:30:00"));

        repository.save(createPrice(1L, 35455L, 3, 1, new BigDecimal("30.50"),
                "EUR", "2020-06-15T00:00:00", "2020-06-15T11:00:00"));

        repository.save(createPrice(1L, 35455L, 4, 1, new BigDecimal("38.95"),
                "EUR", "2020-06-15T16:00:00", "2020-12-31T23:59:59"));
    }

    private PriceEntity createPrice(Long brandId, Long productId, int priceList, int priority,
                                    BigDecimal price, String currency, String start, String end) {
        PriceEntity entity = new PriceEntity();
        entity.setBrandId(brandId);
        entity.setProductId(productId);
        entity.setPriceList(priceList);
        entity.setPriority(priority);
        entity.setPrice(price);
        entity.setCurrency(currency);
        entity.setStartDate(LocalDateTime.parse(start));
        entity.setEndDate(LocalDateTime.parse(end));
        return entity;
    }
}