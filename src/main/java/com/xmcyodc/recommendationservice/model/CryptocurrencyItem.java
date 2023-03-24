package com.xmcyodc.recommendationservice.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.Instant;

@Value
@Builder
public class CryptocurrencyItem {

    BigDecimal price;
    Cryptocurrency symbol;
    Instant evaluatedAt;

}
