package com.xmcyodc.recommendationservice.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CryptocurrencyItem {

    BigDecimal price;
    Cryptocurrency symbol;
    LocalDateTime timestamp;

}
