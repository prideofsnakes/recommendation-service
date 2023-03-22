package com.xmcyodc.recommendationservice.service;

import com.xmcyodc.recommendationservice.model.Cryptocurrency;
import com.xmcyodc.recommendationservice.model.CryptocurrencyItem;
import com.xmcyodc.recommendationservice.repository.CryptocurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final CryptocurrencyRepository normalizedRangeCryptocurrencyRepository;

    @Override
    public List<CryptocurrencyItem> getAllCryptocurrencies() {

        return normalizedRangeCryptocurrencyRepository.getNormalizedRangeValues()
                .stream()
                .map(cryptocurrencyTuple -> CryptocurrencyItem.builder()
                        .price(cryptocurrencyTuple.get(0, BigDecimal.class))
                        .symbol(Cryptocurrency.valueOf(cryptocurrencyTuple.get(1, String.class)))
                        .build()
                )
                .collect(Collectors.toList());
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
