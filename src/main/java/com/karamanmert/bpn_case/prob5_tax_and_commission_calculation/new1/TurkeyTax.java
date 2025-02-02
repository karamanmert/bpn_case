package prob5_tax_and_commission_calculation.new1;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */

/**
 *
 *
 */
public class TurkeyTax implements Tax {

    private static final Double TAX_RATE = 0.18; // KDV // bu değer config'den okunabilir ya da db'den alınabilir.

    @Override
    public BigDecimal calculateTax(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.valueOf(10_000)) > 0)
            return amount.multiply(BigDecimal.valueOf(0.15));
        else
            return amount.multiply(BigDecimal.valueOf(0.10));
    }

    @Override
    public BigDecimal calculateCommission(BigDecimal transactionAmount) {
        return transactionAmount.multiply(BigDecimal.valueOf(0.02)); // %2 komisyon
    }
}