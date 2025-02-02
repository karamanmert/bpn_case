package com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */
@Entity
@Getter
@Setter
@ToString
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    private String countryCode;

    private BigDecimal rate;

    private BigDecimal minAmount;

    private BigDecimal maxAmount;
}
