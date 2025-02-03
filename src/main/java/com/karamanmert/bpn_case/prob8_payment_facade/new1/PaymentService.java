package com.karamanmert.bpn_case.prob8_payment_facade.new1;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */

public interface PaymentService {

    void processPayment(String accountId, BigDecimal amount);
}
