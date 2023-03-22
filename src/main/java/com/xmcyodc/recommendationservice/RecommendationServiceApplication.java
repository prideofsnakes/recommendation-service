package com.xmcyodc.recommendationservice;

import com.xmcyodc.recommendationservice.entity.CryptocurrencyEntity;
import com.xmcyodc.recommendationservice.parser.CsvSourceParser;
import com.xmcyodc.recommendationservice.repository.CryptocurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.stream.Collectors;

@SpringBootApplication
public class RecommendationServiceApplication implements CommandLineRunner {

    @Autowired
    private final CryptocurrencyRepository repository;

    @Autowired
    private final CsvSourceParser parser;

    public RecommendationServiceApplication(CryptocurrencyRepository repository, CsvSourceParser parser) {
        this.repository = repository;
        this.parser = parser;
    }

    public static void main(String[] args) {
        SpringApplication.run(RecommendationServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        repository.saveAll(parser.parseAll()
                .stream()
                .map(cryptocurrencyCsvBean -> {
                    CryptocurrencyEntity entity = new CryptocurrencyEntity();
                    entity.setPrice(cryptocurrencyCsvBean.getPrice());
                    entity.setSymbol(cryptocurrencyCsvBean.getSymbol());
                    entity.setEvaluatedAt(Instant.ofEpochMilli(cryptocurrencyCsvBean.getTimestamp()));
                    return entity;
                })
                .collect(Collectors.toList()));
    }
}
