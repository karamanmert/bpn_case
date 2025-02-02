package com.karamanmert.bpn_case.prob1_calculate_price_method.new1;


import com.karamanmert.bpn_case.prob1_calculate_price_method.Order;

public class DiscountStrategy implements PriceStrategy {

    private static final String EMAIL_POSTFIX = "@corporate.com"; // we can get this from property file or list<String>

    @Override
    public void calculate(Order order) {
        double price = order.getPrice();
        if (order.getCustomerEmail().endsWith(EMAIL_POSTFIX)) {
            price = price * 0.90;
        } else if (price > 10000) {
            price = price - 500;
        } else if (price > 5000) {
            price = price - 200;
        } else {
            price = price * 0.95;
        }
        order.setPrice(price);
    }
}