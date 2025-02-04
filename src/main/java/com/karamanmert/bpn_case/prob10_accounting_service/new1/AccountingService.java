package com.karamanmert.bpn_case.prob10_accounting_service.new1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

// GENERALLEDGERENTRY'NIN BIR DTO OLDUGU FAR EDILMISTIR.
@Service
@RequiredArgsConstructor
public class AccountingService {

    private final GeneralLedgerEntryValidator validator;
    private final AuditService auditService;

    public void postGeneralLedgerEntry(GeneralLedgerEntry entry) {
        // 1. Validation
       validator.validate(entry);

        // 2. IFRS kuralı (basit örnek)
        // todo: pek çok yerde factory ve strategy patter kullandım burada da bunları combine edip kullanabiliriz.
        // todo: bu kurallar her zaman sekmeden arka arkaya çalışması gerekiyorsa chain of res. pattern da kullanılabilir.
        /*
        if (entry.isUnderIFRS()) {
            if (entry.getAccountType().equals("EQUITY")
                    && entry.getDebit().compareTo(BigDecimal.valueOf(100000)) > 0) {
                // Örnek bir kural
                throw new IllegalStateException("Equity hesapları IFRS limit aşımı!");
            }
        }

         */

        // 3. Logging & Audit
        auditService.logEntry(entry);

        // 4. Kalemleri DB'ye kaydet
        // ...
    }
}