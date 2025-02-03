package com.karamanmert.bpn_case.prob8_payment_facade.new1;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */

public interface AccountService {

    void debitAccount(String accountId, BigDecimal amount);

    void compensateDebit(String accountId, BigDecimal amount);
}
