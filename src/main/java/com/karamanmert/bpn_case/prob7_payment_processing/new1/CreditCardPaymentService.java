package com.karamanmert.bpn_case.prob7_payment_processing.new1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author karamanmert
 */
@Service
@RequiredArgsConstructor
public class CreditCardPaymentService implements PaymentService {

    private final FraudDetectionService fraudDetectionService;
    private final ExternalPaymentGatewayService externalPaymentGatewayService;
    private final AccountingService accountingService;

    // private final LogService<PaymentRequest, PaymentGatewayResponse> service; // HANDLING IN ACC. SER


    @Override
    public void processPayment(PaymentRequest request) {
        fraudDetectionService.isValid(request); // if it's not valid, then throw and exception

        PaymentGatewayResponse gatewayResponse = externalPaymentGatewayService.getPaymentGatewayResponse(request);

        accountingService.recordTransaction(request, gatewayResponse);
    }
}
