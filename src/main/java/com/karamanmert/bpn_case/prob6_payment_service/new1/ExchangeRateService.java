package com.karamanmert.bpn_case.prob6_payment_service.new1;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */
public interface ExchangeRateService {

    BigDecimal getRate(Currency from, Currency to);
}
