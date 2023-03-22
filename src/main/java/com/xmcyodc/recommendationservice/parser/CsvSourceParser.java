package com.xmcyodc.recommendationservice.parser;

import com.xmcyodc.recommendationservice.model.Cryptocurrency;
import com.xmcyodc.recommendationservice.model.CryptocurrencyItem;

import java.util.List;

public interface CsvSourceParser {

    List<CryptocurrencyItem> parse();

}
