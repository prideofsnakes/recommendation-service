package com.xmcyodc.recommendationservice.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.Instant;

@Value
@Builder
public class ParticularCryptocurrency {
    BigDecimal maxPrice;
    BigDecimal minPrice;
    Instant oldest;
    Instant newest;
    Cryptocurrency symbol;
}
