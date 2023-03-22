package com.xmcyodc.recommendationservice.repository;

import com.xmcyodc.recommendationservice.entity.CryptocurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CryptocurrencyRepository extends JpaRepository<CryptocurrencyEntity,Long> {
}
