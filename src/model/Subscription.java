package model;

public abstract class Subscription {

    private final String name;
    private final double basePrice;
    private final String tariff;

    public Subscription(String name, double basePrice, String tariff) {
        this.name = name;

        if (basePrice <= 0) {
            System.out.println(
                    "[WARNING] Некорректная цена. Установлена цена 100 руб."
            );
            this.basePrice = 100.0;
        } else {
            this.basePrice = basePrice;
        }

        this.tariff = tariff;
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getTariff() {
        return tariff;
    }

    protected double getTariffCoefficient() {
        return switch (tariff) {
            case "Basic" -> 1.0;
            case "Standard" -> 1.5;
            case "Premium" -> 2.5;
            default -> {
                System.out.println(
                        "[WARNING] Неизвестный тариф: " + tariff
                                + ". Применён коэффициент 1.0."
                );
                yield 1.0;
            }
        };
    }

    public abstract double calculateBillingPrice();

    public double calculateBillingPrice(PromoCode promoCode) {
        double price = calculateBillingPrice();

        if (promoCode == null) {
            return price;
        }

        return price * (1 - promoCode.getDiscountPercent() / 100.0);
    }
}
