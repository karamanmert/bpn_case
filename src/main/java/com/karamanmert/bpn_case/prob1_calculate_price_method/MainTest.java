package com.karamanmert.bpn_case.prob1_calculate_price_method;


import com.karamanmert.bpn_case.prob1_calculate_price_method.new1.*;

import java.util.List;


/**
 * @author karamanmert
 */
public class MainTest {

    public static void main(String[] args) {

        Order order = new Order(
                List.of(ProductType.LAPTOP, ProductType.MONITOR, ProductType.PHONE),
                "mert@corporate.com",
                "Istanbul Türkiye"
        );

        PriceStrategy basePriceStrategy = new BasePriceStrategy();
        PriceStrategy discountStrategy = new DiscountStrategy();
        PriceStrategy taxStrategy = new TaxStrategy();

        PriceCalculator priceCalculator = new PriceCalculator(basePriceStrategy);
        priceCalculator.calculate(order);

        priceCalculator.setPriceStrategy(discountStrategy);
        priceCalculator.calculate(order);

        priceCalculator.setPriceStrategy(taxStrategy);
        priceCalculator.calculate(order);

        System.out.println(order.getPrice());
    }
}
