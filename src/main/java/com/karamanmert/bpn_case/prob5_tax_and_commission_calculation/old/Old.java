package com.karamanmert.bpn_case.prob5_tax_and_commission_calculation.old;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */
/*
Problem
Birden fazla finansal ürün veya ülke pazarında faaliyet gösteren bir uygulamada, vergi (KDV, stopaj) ya da
komisyon oranlarının doğrudan koda gömülmesi bakım ve güncelleme zorlukları doğurur. Nasıl bir çözüm
üretirsiniz ?

tax ve comission bilgileri üründen ürüne veya ülkeden ülkeye değişir. bunları dinamik yapmamız lazım.
 ÇÖZÜM YÖNTEMLERİ
 1- spring boot: taxrate gibi bir entity oluşturursun. orada country, producttype, taxrate gibi bilgiler verirsin.
 repository'den sorgu atarsın ( findByCountryAndProductTypeAndTaxType ..)
 + değerler sabit olacağı için cache kullanılabilir.
 + bu taxrate gibi entity içerisindeki değerler sabit olacağı için sık kullanılanları
 redis tarzı bir cache sisteminden okuyabilir veya yazabiliriz.

 2- property dosyalarında belirtilebilir bu oranlar

 ...
 3- strategy pattern + factory pattern kullan.

 
----


*/
public class Old {

    public BigDecimal calculateTax(BigDecimal amount) {
        // farklı ülkeler içn sabit vergi oranları koda gömülü
        if (amount.compareTo(BigDecimal.valueOf(10_000)) > 0)
            return amount.multiply(BigDecimal.valueOf(0.15)); // %15 vergi
        else
            return amount.multiply(BigDecimal.valueOf(0.10)); // %10 vergi
    }

    public BigDecimal calculateCommission(BigDecimal transactionAmount) {
        // sabit komisyon tutarı
        return transactionAmount.multiply(BigDecimal.valueOf(0.02)); // %2 komisyon
    }
}
