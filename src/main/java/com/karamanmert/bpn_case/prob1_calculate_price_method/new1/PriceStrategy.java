package prob1_calculate_price_method.new1;

import prob1_calculate_price_method.Order;

/**
 * @author karamanmert
 */
public interface PriceStrategy {

    void calculate(Order order); // void dönüp price order'a alındı.

    // double calculate(Order order, double price);
}
