package com.xmcyodc.recommendationservice.service;

import com.xmcyodc.recommendationservice.model.Cryptocurrency;
import com.xmcyodc.recommendationservice.model.CryptocurrencyItem;
import com.xmcyodc.recommendationservice.model.ParticularCryptocurrency;
import com.xmcyodc.recommendationservice.repository.CryptocurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

    private final CryptocurrencyRepository cryptocurrencyRepository;

    @Override
    public List<CryptocurrencyItem> getAllNormalizedRangeCryptocurrencies() {

        return cryptocurrencyRepository.getNormalizedRangeValues()
                .stream()
                .map(cryptocurrencyTuple -> CryptocurrencyItem.builder()
                        .price(cryptocurrencyTuple.get(0, BigDecimal.class))
                        .symbol(Cryptocurrency.valueOf(cryptocurrencyTuple.get(1, String.class)))
                        .build()
                )
                .collect(Collectors.toList());
    }

    @Override
    public ParticularCryptocurrency getParticularCryptocurrency(String cryptocurrency) {
        if (cryptocurrencyRepository.existsBySymbol(cryptocurrency.toUpperCase())) {
            Optional<Tuple> maybeTuple = cryptocurrencyRepository.getParticularCryptocurrency(cryptocurrency.toUpperCase())
                    .stream()
                    .findAny();
            return maybeTuple.map(tuple -> ParticularCryptocurrency.builder()
                            .maxPrice(tuple.get(0, BigDecimal.class))
                            .minPrice(tuple.get(1, BigDecimal.class))
                            .newest(tuple.get(2, Timestamp.class).toInstant())
                            .oldest(tuple.get(3, Timestamp.class).toInstant())
                            .symbol(Cryptocurrency.valueOf(tuple.get(4, String.class)))
                            .build()
                    )
                    .orElseThrow(RuntimeException::new);//TODO: correct
        }
        else throw new IllegalStateException("lalalaalalalalal");//todo: correct
    }

    @Override
    public CryptocurrencyItem getNormalizedRangeCryptocurrencyByDay() {
        return null;
    }
}
