package prob2_shipping_cost_calculator.new1;

/**
 * @author karamanmert
 */
public final class ShippingCostUtil {

    private ShippingCostUtil() {

    }

    public static String calculateShippingCost(int amount, Currency currency) {
        return amount + " " + currency.name();
    }
}
