package prob4_account_balance_calculation.new1;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author karamanmert
 */
// çözüm bigdecimal kullanarak hatalar önlenir.
public class New1 {

    public BigDecimal calculateAccountBalance(BigDecimal initialBalance,
                                              BigDecimal deposit,
                                              BigDecimal feePercentage) {

        final BigDecimal newBalance = initialBalance.add(deposit);

        BigDecimal multiply = newBalance.multiply(feePercentage);
        // todo scale, rMode
        BigDecimal fee = multiply.divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);


        return newBalance.subtract(fee);
    }
}
