package org.example;

public class Order {
    private final String fullName;
    private final String shirtSize;
    private final Boolean withDesign;
    private final Boolean withHoodie;
    private final String payment;

    public Order(String fullName, String shirtSize, Boolean withDesign, Boolean withHoodie, String payment) {
        this.fullName = fullName;
        this.shirtSize = shirtSize;
        this.withDesign = withDesign;
        this.withHoodie = withHoodie;
        this.payment = payment;
    }

    public String getShirtSize() {
        return shirtSize;
    }

    public String getPayment() {
        return payment;
    }

    public Boolean getWithDesign() {
        return withDesign;
    }

    public Boolean getWithHoodie() {
        return withHoodie;
    }
}
