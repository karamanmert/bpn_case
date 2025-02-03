package com.karamanmert.bpn_case.prob7_payment_processing.old;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */

/*
Problem
Aşağıdaki PaymentProcessing sınıfı, bir finans uygulamasında ödeme onayı, fraud kontrolü, API
entegrasyonu ve muhasebe kaydına kadar tüm işleri üstleniyor. Kod büyüdükçe sınıf içi metot sayısı ve
sorumluluklar birbirine girecek. Nasıl bir çözüm üretirsiniz ?

Çözüm
1- Single Res. Princ. ihlal ediyor.
her bir service'in ayrı bir yerde handle edilip burada interface'e bağımlı kalarak çağrılması gerekiliypr ( + DIP )
2- İstek bir dto objesine alınmalı (pojo)
3- FraudDetectionService -> interface tanımlayıp bir strategy pattern ile birden fazla class üzerinden kontrol sağlayabiliriz.
işlemi kısa tutmak amacıyla class olarak ilerttim.
4- method adında credit card ödemesi vardı. bunu class'a taşıdım bu class artık kredi kartı ile ödeme yapacak.
debit ya da bitcoin gibi ayrı kanallar için yeni impl gerekli.
5- log service'i oluşturup düzgünce loglamak gerekli.

artık testi de kolay. genişletilebilir. srp ve dip'e uygun loosely coupled bir kod oldu.
 */
public class PaymentProcessing {

    public void processCreditCardPayment(String cardNumber, String expiration, BigDecimal amount) {
        // Fraud check
        if (!fraudCheck(cardNumber, amount)) {
            throw new RuntimeException("Fraud suspected!");
        }

        // External payment gateway call
        boolean success = callPaymentGateway(cardNumber, expiration, amount);

        // Muhasebe Kaydı
        if (success) {
            recordTransaction(cardNumber, amount);
        }
    }

    private boolean fraudCheck(String cardNumber, BigDecimal amount) {
        // basit bir kontrol
        return amount.compareTo(BigDecimal.valueOf(5000)) < 0;
    }

    private boolean callPaymentGateway(String cardNumber, String expiration, BigDecimal amount) {
        // 3rd party API entegrasyonu
        return true;
    }

    private void recordTransaction(String cardNumber, BigDecimal amount) {
        // Muhasebe sistemine kayıt.
        System.out.println("Transaction recorded for " + cardNumber + ": " + amount);
    }
}
