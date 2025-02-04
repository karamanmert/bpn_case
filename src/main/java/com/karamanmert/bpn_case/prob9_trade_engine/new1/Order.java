package com.karamanmert.bpn_case.prob9_trade_engine.new1;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Version //1. açıklamada yazdım o sebepten kaldırıyorum.
    // private Long version;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Integer quantity;

    private BigDecimal price;
}