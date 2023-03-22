package com.xmcyodc.recommendationservice.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class CryptocurrencyItem {

    BigDecimal price;
    Cryptocurrency symbol;
    Instant evaluatedAt;

}
