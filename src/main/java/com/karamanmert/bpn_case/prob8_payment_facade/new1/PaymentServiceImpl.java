package com.karamanmert.bpn_case.prob8_payment_facade.new1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final AccountService accountService; // TODO: TreasuryService VE LoanService impl'si de buna yapılan gibi yapılmalıydı. kısa tutmak amaçlı bunlar class açtım.
    private final TreasuryService treasuryService;
    private final LoanService loanService;

    @Override
    public void processPayment(String accountId, BigDecimal amount) {
        try {
            // 1- müşteri hesabından para düş
            accountService.debitAccount(accountId, amount);
            log.info("LOG"); // todo: loglama için 7. sorudaki gibi logservice kullanılabilir

            // 2- ödeme hazinesinde takip edilsin.
            treasuryService.registerIncoming(amount);
            log.info("LOG");

            // 3- müşterinin ilgili kredisine (varsa) aktarılsın
            loanService.creditLoan(accountId, amount);
            log.info("LOG");
        } catch (Exception e) {
            log.info("Error occurred: {}", e.getMessage());
            rollbackPayment(accountId, amount);
        }
    }

    private void rollbackPayment(String accountId, BigDecimal amount) {
        try {
            loanService.compensateCredit(accountId, amount);
            treasuryService.compensateRegister(amount);
            accountService.compensateDebit(accountId, amount);
            log.info("Rollback completed successfully.");
        } catch (Exception ex) {
            log.info("Rollback failed: {}", ex.getMessage());
        }
    }
}
