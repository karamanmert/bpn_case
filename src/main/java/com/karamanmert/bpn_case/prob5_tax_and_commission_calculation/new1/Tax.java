package com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.new1;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */
public interface Tax {

    BigDecimal calculateTax(BigDecimal amount);

    BigDecimal calculateCommission(BigDecimal transactionAmount);
}
