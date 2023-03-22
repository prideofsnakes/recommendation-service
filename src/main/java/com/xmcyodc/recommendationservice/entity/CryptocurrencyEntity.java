package com.xmcyodc.recommendationservice.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity(name = "cryptocurrency")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table
@NoArgsConstructor
@AllArgsConstructor
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "get_normalized_crypto",
                query = "select round(((max(c.price)-min(c.price))/min(c.price)),2) as price, " +
                        "symbol from cryptocurrency c group by symbol order by price desc;"
        )
})
public class CryptocurrencyEntity {

    @Id
    @GeneratedValue()
    private Long id;

    private Instant evaluatedAt;

    private String symbol;

    private BigDecimal price;
}
