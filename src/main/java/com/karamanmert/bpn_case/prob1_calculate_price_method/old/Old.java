package com.karamanmert.bpn_case.prob1_calculate_price_method.old;

import com.karamanmert.bpn_case.prob1_calculate_price_method.Order;
import com.karamanmert.bpn_case.prob1_calculate_price_method.new1.ProductType;

;

/**
 * @author karamanmert
 */

/*
Problem
Aşağıdaki calculatePrice metodu, onlarca satıra yayılmış karmaşık if-else yapıları, çeşitli indirim ve vergi
hesaplamaları içeriyor. Metodu okumak, anlamak ve bakımını yapmak zor. Nasıl bir çözüm üretirsiniz ?

ÇÖZÜM
1- tek bir method içerisinde 3 farklı işlem yapılıyor. bu 3 işlemi de ayrı methodlarda çözüp buradan çağır.(ilk aşama)
    daha sonra da bunları ayrı classlarda handle et.2- strategy pattern ile ürünün temel ücretinin üzerine yapılacak, olan  + - fiyatlandırmaları hesaplayabiliriz.
( strategy + factory kullanarak da ihtiyacımız olan objeleri oluşturabiliriz. (burada yapmadım ))
3- price değeri bigdecimal olmalı ama burada ilerletmeyeceğim.
4- product isimleri enumda olmalı.
 */


public class Old {

    public double calculatePrice(Order order) {
        double basePrice = 0.0;

        // Baz fiyat hesaplama
        for (ProductType product : order.getProducts()) {
            if (product.name().equals("Laptop")) {
                basePrice += 7000;
            } else if (product.name().equals("Phone")) {
                basePrice += 3000;
            } else if (product.name().equals("Monitor")) {
                basePrice += 1500;
            } else {
                basePrice += 500;
            }
        }

        // İndirim hesaplama
        if (order.getCustomerEmail().endsWith("@corporate.com")) {
            basePrice = basePrice * 0.90;
        } else {
            if (basePrice > 10000) {
                basePrice = basePrice - 500;
            } else if (basePrice > 5000) {
                basePrice = basePrice - 200;
            } else {
                basePrice = basePrice * 0.95;
            }
        }

        // Vergi hesaplama
        if (order.getShippingAddress().contains("Istanbul")) {
            basePrice += basePrice * 0.18;
        } else {
            basePrice += basePrice * 0.08;
        }

        // Daha pek çok if-else...
        return basePrice;
    }
}