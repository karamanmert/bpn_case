package prob2_shipping_cost_calculator.new1;

/**
 * @author karamanmert
 */
public class Main {

    public static void main(String[] args) {
        ShippingCostDto dto = new ShippingCostDto(
               6, Region.INTERNATIONAL, Currency.USD, Boolean.TRUE
        );
        New1 new1 = new New1();
        String result = new1.getShippingCost(dto);
        System.out.println(result);
    }
}
