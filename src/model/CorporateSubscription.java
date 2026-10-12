package model;

public class CorporateSubscription extends Subscription {

    private final int activeLicensesCount;

    public CorporateSubscription(
            String name,
            double basePrice,
            String tariff,
            int activeLicensesCount
    ) {
        super(name, basePrice, tariff);

        if (activeLicensesCount < 1) {
            System.out.println(
                    "[WARNING] Число лицензий должно быть не меньше 1. "
                            + "Установлена 1 лицензия."
            );
            this.activeLicensesCount = 1;
        } else {
            this.activeLicensesCount = activeLicensesCount;
        }
    }

    public int getActiveLicensesCount() {
        return activeLicensesCount;
    }

    @Override
    public double calculateBillingPrice() {
        return getBasePrice() * getTariffCoefficient() * activeLicensesCount;
    }

    @Override
    public double calculateBillingPrice(PromoCode promoCode) {
        if (promoCode != null) {
            System.out.println(
                    "[WARNING] Корпоративным клиентам промокоды не предоставляются."
            );
        }

        return calculateBillingPrice();
    }
}
