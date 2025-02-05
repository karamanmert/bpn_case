package com.karamanmert.bpn_case.prob6_payment_service.old;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */
/*
Problem
Aşağıdaki kod parçasında, ödeme veya fatura sisteminde döviz çevirimi yapan bir sınıf doğrudan bir
“ExchangeRateService”e sıkı sıkıya bağımlı. Ayrıca desteklenen tüm döviz çiftleri de koda gömülü (if-else
veya switch yapısı). Nasıl bir çözüm üretirsiniz ?

ÇÖZÜM
Bir class'a bağımlı olmamak bir abstraction a bağlı olmak lazım => DIP
if elselerden kurtulmak için ise bir her bir birim için bir service oluşturup, factory ile nesne üretilip,
 bir map tutulup , mapte tutulan veya 5. örnekteki gibi
5 10 snde bir cacheden okuyan bir işlemle ilerletebiliriz.

ben burada live bir servis kullanmak istedim. böylece her bir currency tipi için service oluşturmayacağım.

  // todo: eğer bir schedule job ile db'yi sürekli güncel tutar ve db'den çekersek maliyetli olabilir.
    // todo: eğer istek attığımız yerden(EXTERNAL API), hata alırsak circuit breaker tarzı patternlar kullabiliriz.
    // todo: status 200 değilse, daha önceden hazırlanan 2-3 fakrlı live exhange apisinden başka birine istek atabiliriz.
    // todo: birden fazla api'a istek atıp, gelen ratelerin ortalamaları ile bir map oluşturup oradan da alınabilir.

 */
public class PaymentService {

    private ExchangeRateService exchangeRateService = new ExchangeRateService();

    public BigDecimal convertCurrency(BigDecimal amount, String from, String to) {
        if (from.equals("USD") && to.equals("EUR")) {
            BigDecimal rate = exchangeRateService.getRate("USD", "EUR");
            return amount.multiply(rate);
        }else if (from.equals("EUR") && to.equals("USD")) {
            BigDecimal rate = exchangeRateService.getRate("USD", "EUR");
            return amount.multiply(rate);
        }
        // daha fazla if else

        throw new UnsupportedOperationException("Conversion not supported");
    }
}

class ExchangeRateService {
    public BigDecimal getRate(String from, String to) {
        // API VEYA SABIT TABLO
        return BigDecimal.valueOf(0.90);
    }
}