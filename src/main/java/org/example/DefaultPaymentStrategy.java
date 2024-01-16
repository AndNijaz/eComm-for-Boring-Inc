package org.example;

public class DefaultPaymentStrategy implements PaymentStrategy {
    @Override
    public double calculateTransactionFee(double transactionAmount) {
        return transactionAmount * 0.10;
    }
}
