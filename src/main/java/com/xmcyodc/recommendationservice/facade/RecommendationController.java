package com.xmcyodc.recommendationservice.facade;

import com.xmcyodc.recommendationservice.model.Cryptocurrency;
import com.xmcyodc.recommendationservice.model.CryptocurrencyItem;
import com.xmcyodc.recommendationservice.service.RecommendationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cryptocurrencies")
@AllArgsConstructor
public class RecommendationController {

    private final RecommendationService service;

    @GetMapping()
    public List<CryptocurrencyItem> getAllCryptocurrencies(){
        return service.getAllCryptocurrencies();
    }

    @GetMapping("/{crypto}")
    public CryptocurrencyItem getParticularCryptocurrency(@PathVariable Cryptocurrency crypto){
        return service.getParticularCryptocurrency();
    }
}
