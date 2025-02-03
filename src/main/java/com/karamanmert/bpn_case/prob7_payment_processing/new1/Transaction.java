package com.karamanmert.bpn_case.prob7_payment_processing.new1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author karamanmert
 */
@Entity
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;
    private String cardNumber;
    private Integer statusCode;
    //...
}
