package com.xmcyodc.recommendationservice.facade;

import com.xmcyodc.recommendationservice.model.CryptocurrencyItem;
import com.xmcyodc.recommendationservice.model.ParticularCryptocurrency;
import com.xmcyodc.recommendationservice.service.RecommendationService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cryptocurrencies")
@AllArgsConstructor
public class RecommendationController {

    private final RecommendationService service;

    @GetMapping()
    public List<CryptocurrencyItem> getNormalizedRangeCryptocurrencies() {
        return service.getAllNormalizedRangeCryptocurrencies();
    }

    @GetMapping("/{crypto}")
    public ParticularCryptocurrency getParticularCryptocurrency(@PathVariable String crypto) {
        return service.getParticularCryptocurrency(crypto);
    }

    @GetMapping("/bydate")
    public CryptocurrencyItem getNormalizedRangeCryptocurrencyByDate(@RequestParam("date")
                                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return service.getNormalizedRangeCryptocurrencyByDate(date);
    }
}
