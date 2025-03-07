package com.karamanmert.bpn_case.prob1_calculate_price_method.new1;


import com.karamanmert.bpn_case.prob1_calculate_price_method.Order;

public class PriceCalculator {

    // TODO: BURASI LISTE DE ALABİLİRD. TYPE İLE HANGİLERİNİ UYGULAMAK İSTEDİĞİMİZİ VEREBİLİRDİK.
    private PriceStrategy priceStrategy;

    public PriceCalculator(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public void setPriceStrategy(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public void calculate(Order order) {
        this.priceStrategy.calculate(order);
    }
}