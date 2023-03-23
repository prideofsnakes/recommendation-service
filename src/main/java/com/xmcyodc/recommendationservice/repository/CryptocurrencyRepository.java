package com.xmcyodc.recommendationservice.repository;

import com.xmcyodc.recommendationservice.entity.CryptocurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.time.LocalDate;
import java.util.List;

public interface CryptocurrencyRepository extends JpaRepository<CryptocurrencyEntity,Long> {

    boolean existsBySymbol(String symbol);
    @Query(name = "get_normalized_crypto", nativeQuery = true)
    List<Tuple> getNormalizedRangeValues();

    @Query(name = "get_oldest_newest_max_min_crypto", nativeQuery = true)
    List<Tuple> getParticularCryptocurrency(@Param("cryptoName") String cryptoName);

    @Query(name = "get_normalized_crypto_by_date", nativeQuery = true)
    List<Tuple> getNormalizedRangeValuesByDate(@Param("date") LocalDate date);
}
