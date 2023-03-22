package com.xmcyodc.recommendationservice.service;

import com.xmcyodc.recommendationservice.model.CryptocurrencyItem;

import java.util.List;

public interface RecommendationService {
    List<CryptocurrencyItem> getAllCryptocurrencies();
    CryptocurrencyItem getParticularCryptocurrency();
    CryptocurrencyItem getParticularCryptocurrencyByDay();
}
