package prob1_calculate_price_method.new1;

import prob1_calculate_price_method.Order;

public class PriceCalculator {

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