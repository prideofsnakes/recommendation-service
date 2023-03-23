package com.xmcyodc.recommendationservice.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class ParticularCryptocurrency {
    BigDecimal maxPrice;
    BigDecimal minPrice;
    Instant oldest;
    Instant newest;
    Cryptocurrency symbol;
}
