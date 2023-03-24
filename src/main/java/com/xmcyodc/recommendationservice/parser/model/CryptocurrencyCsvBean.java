package com.xmcyodc.recommendationservice.parser.model;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
public class CryptocurrencyCsvBean extends CsvBean{
    @CsvBindByName
    String symbol;

    @CsvBindByName
    BigDecimal price;

    @CsvBindByName
    Long timestamp;
}
