package com.xmcyodc.recommendationservice;

import com.xmcyodc.recommendationservice.exception.CryptoNotFoundException;
import com.xmcyodc.recommendationservice.exception.WrongEvaluatedDateException;
import com.xmcyodc.recommendationservice.model.Cryptocurrency;
import com.xmcyodc.recommendationservice.model.CryptocurrencyItem;
import com.xmcyodc.recommendationservice.model.ParticularCryptocurrency;
import com.xmcyodc.recommendationservice.service.RecommendationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class RecommendationServiceTest {

    @Mock
    RecommendationService service;

    @Test
    @DisplayName("check that service retrieves array of items")
    void testGetAllNormalizedRangeCryptocurrencies() {
        // Arrange
        List<CryptocurrencyItem> items = new ArrayList<>();
        items.add(CryptocurrencyItem.builder().price(new BigDecimal(100)).symbol(Cryptocurrency.BTC).build());
        items.add(CryptocurrencyItem.builder().price(new BigDecimal(200)).symbol(Cryptocurrency.ETH).build());
        when(service.getAllNormalizedRangeCryptocurrencies()).thenReturn(items);

        // Act
        List<CryptocurrencyItem> result = service.getAllNormalizedRangeCryptocurrencies();

        // Assert
        assertEquals(2, result.size());
        assertEquals(BigDecimal.valueOf(100), result.get(0).getPrice());
        assertEquals(Cryptocurrency.BTC, result.get(0).getSymbol());
        assertEquals(BigDecimal.valueOf(200), result.get(1).getPrice());
        assertEquals(Cryptocurrency.ETH, result.get(1).getSymbol());
    }

    @Test
    @DisplayName("check that service retrieves particular crypto with min/max/old/new values")
    void testGetParticularCryptocurrency_success() {
        // Arrange
        final ParticularCryptocurrency given = ParticularCryptocurrency.builder()
                .maxPrice(new BigDecimal(100))
                .minPrice(new BigDecimal(50))
                .symbol(Cryptocurrency.BTC)
                .build();
        when(service.getParticularCryptocurrency("BTC")).thenReturn(given);

        // Act
        ParticularCryptocurrency result = service.getParticularCryptocurrency("BTC");

        // Assert
        assertNotNull(result);
        assertEquals(BigDecimal.valueOf(100), result.getMaxPrice());
        assertEquals(BigDecimal.valueOf(50), result.getMinPrice());
        assertEquals(Cryptocurrency.BTC, result.getSymbol());
    }

    @Test
    @DisplayName("check that service retrieves crypto with max normalized range value")
    void testGetNormalizedCryptocurrencyByDay_success() {
        // Arrange
        final CryptocurrencyItem given = CryptocurrencyItem.builder()
                .symbol(Cryptocurrency.ETH)
                .build();
        when(service.getNormalizedRangeCryptocurrencyByDate(LocalDate.of(2022, 1 ,1))).thenReturn(given);

        // Act
        CryptocurrencyItem result = service.getNormalizedRangeCryptocurrencyByDate(LocalDate.of(2022, 1 ,1));

        // Assert
        assertNotNull(result);
        assertEquals(Cryptocurrency.ETH, result.getSymbol());
    }

    @Test
    @DisplayName("check that service throws exception when trying to get non-existent crypto")
    void testGetParticularCryptocurrency_throws_exception() {
        // Arrange
        when(service.getParticularCryptocurrency(anyString())).thenThrow(CryptoNotFoundException.class);

        // Assert
        assertThrows(CryptoNotFoundException.class, () -> {
            service.getParticularCryptocurrency("donnowhat");
        });
    }

    @Test
    @DisplayName("check that service throws exception when trying to get out of date max")
    void testGetNormalizedRangeCryptocurrency_throws_exception() {
        // Arrange
        when(service.getNormalizedRangeCryptocurrencyByDate(LocalDate.of(1999, 1 ,1))).thenThrow(WrongEvaluatedDateException.class);

        // Assert
        assertThrows(WrongEvaluatedDateException.class, () -> {
            service.getNormalizedRangeCryptocurrencyByDate(LocalDate.of(1999, 1 ,1));
        });
    }

}
