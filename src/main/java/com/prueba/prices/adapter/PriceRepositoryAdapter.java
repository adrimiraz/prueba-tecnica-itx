package com.prueba.prices.adapter;
import org.springframework.stereotype.Component;

import com.prueba.prices.domain.model.Price;
import com.prueba.prices.domain.port.out.PriceRepository;
import com.prueba.prices.persistence.JpaPriceRepository;
import com.prueba.prices.persistence.entity.PriceEntity;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PriceRepositoryAdapter implements PriceRepository {
    private final JpaPriceRepository jpaRepo;

    public PriceRepositoryAdapter(JpaPriceRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Optional<Price> findApplicablePrice(LocalDateTime date, Long productId, Long brandId) {
        return jpaRepo
            .findTopByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfterOrderByPriorityDesc(
                productId, brandId, date, date
            )
            .map(this::toDomain);
    }

    private Price toDomain(PriceEntity e) {
        return new Price(e.getBrandId(), e.getProductId(), e.getPriceList(), e.getPriority(),
                e.getPrice(), e.getCurrency(), e.getStartDate(), e.getEndDate());
    }
}