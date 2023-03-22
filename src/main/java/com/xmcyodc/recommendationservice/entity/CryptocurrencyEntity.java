package com.xmcyodc.recommendationservice.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.Instant;

@Entity(name = "cryptocurrency")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table
public class CryptocurrencyEntity {

    @Id
    @GeneratedValue()
    private Long id;

    private Instant evaluatedAt;

    private String symbol;

    private BigDecimal price;
}
