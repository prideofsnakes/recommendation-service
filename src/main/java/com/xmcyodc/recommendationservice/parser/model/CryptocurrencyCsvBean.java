package com.xmcyodc.recommendationservice.parser.model;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class CryptocurrencyCsvBean extends CsvBean{
    @CsvBindByName
    private String symbol;

    @CsvBindByName
    private BigDecimal price;

    @CsvBindByName
    private Long timestamp;
}
