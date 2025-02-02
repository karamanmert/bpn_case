package prob5_tax_and_commission_calculation.new1;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */

// TODO SPRING
public class Main {

    public static void main(String[] args) {
        Tax taxStrategy = TaxFactory.getTaxStrategy(Country.TURKEY);
        BigDecimal tax = taxStrategy.calculateTax(BigDecimal.valueOf(10_001));
        System.out.println(tax);
    }
}
