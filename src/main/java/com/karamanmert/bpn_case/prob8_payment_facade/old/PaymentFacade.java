package com.karamanmert.bpn_case.prob8_payment_facade.old;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */

/*
Problem - Karmaşık ve Yanlış Yönetilen Dağıtık İşlem (Distributed Transaction)
Bir ödeme işleminde aynı anda birkaç farklı finansal kaynağa (ör. birden fazla veritabanı, mikroservis,
harici ödeme ağ geçidi) yazma işlemi yapılıyor. Kod aşağıdaki gibi “yarı dağıtık” bir mantık içeriyor.
Aşağıdaki ipucunu değerlendirerek nasıl bir çözüm üretirsiniz

İpucu:
• Transaction Boundary Sorunu: Müşteri hesabından para düştükten sonra treasury veya loan
servisinde hata oluşursa, sistemi geri almak için “rollback” mekanizması bulunmuyor.
• Çoklu Kaynak: İki ayrı veritabanı ve bir harici servis, tek bir “acid transaction” ile yönetilmiyor.
• Code Smell: Tek bir metot içinde, farklı veri kaynaklarına dokunan “spaghetti” çağrılar ve net
olmayan hata/rollback yönetimi.

ÇÖZÜM
--
tek bir transactional blog'a alamadığımız için veri tutarlılığını sağlamamız lazım.
SAGA PATTERN -> Orchestrator ***
+ DIP için bağımlılıkların abstraction olması lazım.
Hata alan yere, tüm işlemleri geri almadan bir job ile tekrar deneme yapılabilir. ( 1. adım çok uzun sürebilir 2. de hata alırsa 1. yi tekrar  yapmasın gibi )
 */
public class PaymentFacade {

    private AccountRepository accountRepository = new AccountRepository(); // DB1
    private TreasuryService treasuryService = new TreasuryService();       // Harici ms
    private LoanService loanService = new LoanService();                   // DB2

    public void processPayment(String accountId, BigDecimal amount) {
        // 1- müşteri hesabından para düş
        accountRepository.debitAccount(accountId, amount);

        // 2- ödeme hazinesinde takip edilsin.
        treasuryService.registerIncoming(amount);

        // 3- müşterinin ilgili kredisine (varsa) aktarılsın
        loanService.creditLoan(accountId, amount);

        // HATA YONETIMI YOK!
        // TRANSACTION BOUNDRIES NET DEĞİL.
    }
}

class AccountRepository {
    void debitAccount(String accountId, BigDecimal amount) {

    }
}

class TreasuryService {
    void registerIncoming(BigDecimal amount) {

    }
}

class LoanService {
    void creditLoan(String accountId, BigDecimal amount) {

    }
}