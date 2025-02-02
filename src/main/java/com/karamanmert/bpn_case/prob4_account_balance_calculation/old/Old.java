package com.karamanmert.bpn_case.prob4_account_balance_calculation.old;

/**
 * Problem
 * Finans uygulamalarında, para hesaplamalarında kesinlik (precision) kritik öneme sahiptir. Aşağıdaki
 * kodda double veya float kullanarak yapılan işlemler, hatalı sonuçlara neden olabilir (ör. “0.9999999998”
 * gibi). Nasıl bir çözüm üretirsiniz ?
 */
public class Old {

    public double calculateAccountBalance(double initialBalance,
                                          double deposit,
                                          double feePercentage) {
        double newBalance = initialBalance + deposit;
        double fee = newBalance * feePercentage / 100;
        return newBalance - fee;
    }
}