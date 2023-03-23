package com.xmcyodc.recommendationservice.service;

import com.xmcyodc.recommendationservice.model.CryptocurrencyItem;
import com.xmcyodc.recommendationservice.model.ParticularCryptocurrency;

import java.time.LocalDate;
import java.util.List;

public interface RecommendationService {
    List<CryptocurrencyItem> getAllNormalizedRangeCryptocurrencies();
    ParticularCryptocurrency getParticularCryptocurrency(String cryptocurrency);
    CryptocurrencyItem getNormalizedRangeCryptocurrencyByDate(LocalDate date);
}
