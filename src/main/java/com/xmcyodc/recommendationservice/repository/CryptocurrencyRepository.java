package com.xmcyodc.recommendationservice.repository;

import com.xmcyodc.recommendationservice.entity.CryptocurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;
import java.util.List;

public interface CryptocurrencyRepository extends JpaRepository<CryptocurrencyEntity,Long> {

    @Query(name = "get_normalized_crypto", nativeQuery = true)
    List<Tuple> getNormalizedRangeValues();
}
