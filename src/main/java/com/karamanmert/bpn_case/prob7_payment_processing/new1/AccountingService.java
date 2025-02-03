package com.karamanmert.bpn_case.prob7_payment_processing.new1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author karamanmert
 */
@Service
@RequiredArgsConstructor
public class AccountingService {

    private final LogService<PaymentRequest, PaymentGatewayResponse> logService;

    void recordTransaction(PaymentRequest request, PaymentGatewayResponse response) {
        // işlemler
        logService.log(request, response);
    }
}
