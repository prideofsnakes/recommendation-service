package com.xmcyodc.recommendationservice.service;

import com.xmcyodc.recommendationservice.model.CryptocurrencyItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService{

    @Override
    public List<CryptocurrencyItem> getAllCryptocurrencies() {
        return null;
    }

    @Override
    public CryptocurrencyItem getParticularCryptocurrency() {
        return null;
    }

    @Override
    public CryptocurrencyItem getParticularCryptocurrencyByDay() {
        return null;
    }
}
