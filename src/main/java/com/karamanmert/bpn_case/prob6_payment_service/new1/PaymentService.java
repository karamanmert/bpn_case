package com.karamanmert.bpn_case.prob6_payment_service.new1;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */
@Service
public class PaymentService {

    private final ExchangeRateService exchangeRateService;

    public PaymentService(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    public BigDecimal convertCurrency(BigDecimal amount, Currency from, Currency to) {
        BigDecimal rate = exchangeRateService.getRate(from, to);
        return amount.multiply(rate);
    }
}