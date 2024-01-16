package org.example;

public class PaymentContext {
    private final PaymentStrategy paymentStrategy;

    public PaymentContext(String paymentStrategy) {
        //this.paymentStrategy = paymentStrategy;
        switch (paymentStrategy) {
            case "wallet" -> this.paymentStrategy = new WalletPaymentStrategy();
            case "bankcard" -> this.paymentStrategy = new BankCardPaymentStrategy();
            case "visa" -> this.paymentStrategy = new VisaPaymentStrategy();
            case "mastercard" -> this.paymentStrategy = new MasterCardPaymentStrategy();
            default -> this.paymentStrategy = new DefaultPaymentStrategy();
        }
    }

    public double processTransaction(double transactionAmount) {
        double transactionFee = paymentStrategy.calculateTransactionFee(transactionAmount);
        return transactionAmount - transactionFee;
    }
}
