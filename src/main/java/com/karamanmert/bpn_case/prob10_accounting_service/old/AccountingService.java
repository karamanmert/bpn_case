package com.karamanmert.bpn_case.prob10_accounting_service.old;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */
/*
Problem - Muhasebe Kurallarıyla Karışık, Çok Katmanlı Validation ve Denetim (Audit)
Aşağıdaki “AccountingService” sınıfı, bir finans kurumunda farklı raporlama ve muhasebe standartları
(IFRS, US GAAP vb.) gereği birçok validation, business rule ve audit kaydını iç içe yapıyor:
Aşağıdaki ipucunu değerlendirerek nasıl bir çözüm üretirsiniz ?

İpucu:
• Validation + İş Mantığı + Denetim tek bir metotta toplanmış.
• Farklı regülasyonlar, raporlama standartları (IFRS, US GAAP, local GAAP vb.) ile eklendikçe if-else
yığını artacak.
• Muhasebe veya raporlama yazılımında denetim (audit) kayıtları çok önemlidir, ancak burada
gelişigüzel “println” ile yapılmış gibi duruyor.

ÇÖZÜM:
* SRP uygula. methoddaki her bir yeri ayrı yerlerde handle et.
*
* log service yaz.
 */
public class AccountingService {
    public void postGeneralLedgerEntry(GeneralLedgerEntry entry) {
        // 1. Validation
        if (entry.getDebit().compareTo(BigDecimal.ZERO) < 0
                || entry.getCredit().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amounts cannot be negative");
        }

        if (!entry.getAccountType().matches("ASSET|LIABILITY|EQUITY")) {
            throw new IllegalArgumentException("Invalid account type");
        }

        // 2. IFRS kuralı (basit örnek)
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
        System.out.println("Posting to ledger: " + entry);

        // 4. Kalemleri DB'ye kaydet
        // ...
    }
}

@Getter
@Setter
class GeneralLedgerEntry {
    private BigDecimal debit;
    private BigDecimal credit;
    private String accountType;
    private boolean underIFRS;
}