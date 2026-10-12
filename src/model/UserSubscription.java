package model;

public class UserSubscription extends Subscription {

    public UserSubscription(String name, double basePrice, String tariff) {
        super(name, basePrice, tariff);
    }

    @Override
    public double calculateBillingPrice() {
        return getBasePrice() * getTariffCoefficient();
    }
}
