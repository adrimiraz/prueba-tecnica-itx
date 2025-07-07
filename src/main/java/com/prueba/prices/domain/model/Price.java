package com.prueba.prices.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data; 

@Data
@AllArgsConstructor
public class Price {
    private final Long brandId;
    private final Long productId;
    private final Integer priceList;
    private final Integer priority;
    private final BigDecimal price;
    private final String currency;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
}