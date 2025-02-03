package com.karamanmert.bpn_case.prob8_payment_facade.new1;

import com.karamanmert.bpn_case.prob8_payment_facade.new1.repo.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository repository;

    public void debitAccount(String accountId, BigDecimal amount) {
        // repository find by accountId and amount THEN
        // processes
    }

    @Override
    public void compensateDebit(String accountId, BigDecimal amount) {

    }
}
