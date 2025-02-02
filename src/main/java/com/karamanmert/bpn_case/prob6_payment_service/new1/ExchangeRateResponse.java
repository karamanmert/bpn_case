package com.karamanmert.bpn_case.prob6_payment_service.new1;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author karamanmert
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public  class ExchangeRateResponse {
    private String base;
    private Map<String, BigDecimal> rates;
    private String date;
}