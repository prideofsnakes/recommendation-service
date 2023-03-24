package com.xmcyodc.recommendationservice;

import com.xmcyodc.recommendationservice.entity.CryptocurrencyEntity;
import com.xmcyodc.recommendationservice.parser.CsvSourceParser;
import com.xmcyodc.recommendationservice.repository.CryptocurrencyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
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
        log.info("/----> Parsing CSV files from ../resources/static/csv has been started");
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
        log.info("/----> CSV files parsing has been successfully completed");
    }
}
