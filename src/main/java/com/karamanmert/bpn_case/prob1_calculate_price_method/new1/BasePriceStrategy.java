package prob1_calculate_price_method.new1;

import prob1_calculate_price_method.Order;

import java.util.Map;

public class BasePriceStrategy implements PriceStrategy {

    private static final Map<ProductType, Double> PRODUCT_PRICES = Map.of(
        ProductType.LAPTOP, 7000.0,
        ProductType.MONITOR, 3000.0,
        ProductType.PHONE, 1500.0
    );

    @Override
    public void calculate(Order order) {
        double price = order.getProducts().stream()
                .mapToDouble(product -> PRODUCT_PRICES.getOrDefault(product, 500.0))
                .sum();
        order.setPrice(price);
    }
}