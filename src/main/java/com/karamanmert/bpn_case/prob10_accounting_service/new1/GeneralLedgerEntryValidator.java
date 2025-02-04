package com.karamanmert.bpn_case.prob10_accounting_service.new1;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */
@Service
public class GeneralLedgerEntryValidator {

    public void validate(GeneralLedgerEntry entry){
        BigDecimal debit = entry.getDebit();
        BigDecimal credit = entry.getCredit();
        String accountType = entry.getAccountType();

        if (debit.compareTo(BigDecimal.ZERO) < 0 || credit.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amounts cannot be negative");
        }

        if (!accountType.matches("ASSET|LIABILITY|EQUITY")) { // BU DEĞERLER ENUMDAN GELECEK. UYGULAMIYORUM SIMDILIK
            throw new IllegalArgumentException("Invalid account type");
        }
    }
}
