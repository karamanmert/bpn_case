package prob1_calculate_price_method.old;

import prob1_calculate_price_method.Order;
import prob1_calculate_price_method.new1.ProductType;

/**
 * @author karamanmert
 */

/*
Problem
Aşağıdaki calculatePrice metodu, onlarca satıra yayılmış karmaşık if-else yapıları, çeşitli indirim ve vergi
hesaplamaları içeriyor. Metodu okumak, anlamak ve bakımını yapmak zor. Nasıl bir çözüm üretirsiniz ?

ÇÖZÜM
1- tek bir method içerisinde 3 farklı işlem yapılıyor. bu 3 işlemi de ayrı methodlarda çözüp buradan çağır. daha sonra da bunları ayrı classlarda çöz.
2- price değeri bigdecimal olabilir ama burada ilerletmeyeceğim.
3- product isimleri enumda olmalı.
4- sabit stringler en yukarda yazılmalı
 */


public class OldVersion {

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