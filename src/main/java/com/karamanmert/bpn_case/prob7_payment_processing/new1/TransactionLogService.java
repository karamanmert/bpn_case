package com.karamanmert.bpn_case.prob7_payment_processing.new1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author karamanmert
 */
@Service
@Slf4j
public class TransactionLogService implements LogService<PaymentRequest, PaymentGatewayResponse> {

    @Override
    public void log(PaymentRequest request, PaymentGatewayResponse response) {
        Transaction transaction = new Transaction();
        transaction.setStatusCode(response.status);
        transaction.setCardNumber(maskCardNumber(request.cardNumber()));
        // ...
        log.info("gerekli alanlar loglanır.");
    }

    // sensitive info maskelenir. // BUNA SERVICE DE yazılabilir.
    private String maskCardNumber(String cardNumber) {
        return "****-****-****-";
    }
}
