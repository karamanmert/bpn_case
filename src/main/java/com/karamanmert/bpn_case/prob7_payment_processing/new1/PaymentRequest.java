package com.karamanmert.bpn_case.prob7_payment_processing.new1;

import lombok.Builder;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */

@Builder
public record PaymentRequest(String cardNumber,
                             // PaymentType type ??
                             BigDecimal amount) {
}
