package com.karamanmert.bpn_case.prob4_account_balance_calculation.new1;

import java.math.BigDecimal;

/**
 * @author karamanmert
 */
public class Main {
    public static void main(String[] args) {
        New1 new1 = new New1();
        BigDecimal initialBalance = BigDecimal.valueOf(123123.13);
        BigDecimal deposit = BigDecimal.valueOf(12399.99);
        BigDecimal feePercentage = BigDecimal.valueOf(12.5);

        BigDecimal bigDecimal = new1.calculateAccountBalance(initialBalance, deposit, feePercentage);
        System.out.println(bigDecimal);
    }
}
