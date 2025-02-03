package com.karamanmert.bpn_case.prob7_payment_processing.new1;

import org.springframework.stereotype.Service;

/**
 * @author karamanmert
 */
@Service
// interface oluşturup impl'sinde halletmeliyiz ki dip'e sadık kalalım. kısa olsun diye class verdim.
public class ExternalPaymentGatewayService {

    public PaymentGatewayResponse getPaymentGatewayResponse(PaymentRequest request){
        return new PaymentGatewayResponse();
    }
}
