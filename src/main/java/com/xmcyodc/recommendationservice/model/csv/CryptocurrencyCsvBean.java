package com.xmcyodc.recommendationservice.model.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

import java.math.BigDecimal;

@Data
public class CryptocurrencyCsvBean{
    @CsvBindByName
    String symbol;

    @CsvBindByName
    BigDecimal price;

    @CsvBindByName
    Long timestamp;
}
