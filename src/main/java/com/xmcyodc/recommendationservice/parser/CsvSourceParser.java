package com.xmcyodc.recommendationservice.parser;

import com.xmcyodc.recommendationservice.model.csv.CryptocurrencyCsvBean;

import java.util.List;

public interface CsvSourceParser {

    List<CryptocurrencyCsvBean> parseAll();

}
