package com.xmcyodc.recommendationservice.parser;

import com.xmcyodc.recommendationservice.parser.model.CryptocurrencyCsvBean;

import java.util.List;

public interface CsvSourceParser {

    List<CryptocurrencyCsvBean> parseAll();

}
