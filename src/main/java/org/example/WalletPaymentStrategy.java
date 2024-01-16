package org.example;

public class WalletPaymentStrategy implements PaymentStrategy {
    @Override
    public double calculateTransactionFee(double transactionAmount) {
        return 0.0;
    }
}
