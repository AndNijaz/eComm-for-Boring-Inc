package org.example;

public class MasterCardPaymentStrategy implements PaymentStrategy {
    @Override
    public double calculateTransactionFee(double transactionAmount) {
        return transactionAmount * 0.03;
    }
}