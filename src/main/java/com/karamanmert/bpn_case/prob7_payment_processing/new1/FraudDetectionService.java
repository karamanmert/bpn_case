package com.karamanmert.bpn_case.prob7_payment_processing.new1;

import org.springframework.stereotype.Service;

/**
 * @author karamanmert
 */
@Service
// TODO: interface tanımlayıp bir strategy pattern ile birden fazla class üzerinden kontrol sağlayabiliriz. işlemi kısa tutmak amacıyla class olarak ilerttim.
// TODO: EĞER işlemler basit ise ve bir bağımlılığı yoksa UTIL olarak tanımlanabilir.
public class FraudDetectionService {

    void isValid(PaymentRequest request) {
        //if valid ok
        // or THROW EXCEPTION
    }
}
