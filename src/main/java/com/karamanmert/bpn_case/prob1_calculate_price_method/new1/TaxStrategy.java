package prob1_calculate_price_method.new1;

import prob1_calculate_price_method.Order;

public class TaxStrategy implements PriceStrategy {

    private static final String CITY = "Istanbul";

    @Override
    public void calculate(Order order) {
        double price = order.getPrice();
        if (order.getShippingAddress().contains(CITY)) {
            price += price * 0.18;
        } else {
            price += price * 0.08;
        }
        order.setPrice(price);
    }
}