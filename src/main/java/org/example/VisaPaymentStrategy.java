package org.example;

public class VisaPaymentStrategy implements PaymentStrategy {
    @Override
    public double calculateTransactionFee(double transactionAmount) {
        return transactionAmount * 0.02;
    }
}
