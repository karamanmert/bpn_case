package com.karamanmert.bpn_case.prob6_payment_service.new1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Örnek GET endpoint:
     * /api/payments/convert?amount=100&from=USD&to=EUR
     */
    @GetMapping("/convert")
    public BigDecimal convert(
            @RequestParam BigDecimal amount,
            @RequestParam String from,
            @RequestParam String to
    ) {

        Currency fromCurrency = Currency.valueOf(from);
        Currency toCurrency = Currency.valueOf(to);
        return paymentService.convertCurrency(amount, fromCurrency, toCurrency);
    }
}