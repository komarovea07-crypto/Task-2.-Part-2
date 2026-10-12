import billing.Billing;
import model.CorporateSubscription;
import model.PromoCode;
import model.Subscription;
import model.UserSubscription;
import service.impl.EmailNotification;
import service.impl.SmsNotification;

public class Main {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("       СИСТЕМА УЧЁТА ПОДПИСОК");
        System.out.println("======================================\n");

        Subscription userSubscription = new UserSubscription(
                "Личная подписка",
                1000.0,
                "Standard"
        );

        PromoCode promoCode = new PromoCode("WELCOME10", 10);
        double userPrice = userSubscription.calculateBillingPrice(promoCode);

        Billing smsBilling = new Billing(new SmsNotification());

        System.out.println("Оплата физического лица");
        System.out.printf("Стоимость: %.2f руб.%n", userPrice);
        smsBilling.processPayment(
                userSubscription,
                "+79991234567",
                userPrice
        );

        Subscription corporateSubscription = new CorporateSubscription(
                "Корпоративная подписка",
                1000.0,
                "Standard",
                5
        );

        double corporatePrice = corporateSubscription.calculateBillingPrice();
        Billing emailBilling = new Billing(new EmailNotification());

        System.out.println("\nОплата корпоративного клиента");
        System.out.printf("Стоимость: %.2f руб.%n", corporatePrice);
        emailBilling.processPayment(
                corporateSubscription,
                "company@example.com",
                corporatePrice
        );

        System.out.println("\nПроверка корпоративного промокода");
        corporateSubscription.calculateBillingPrice(promoCode);

        Billing.printGlobalStats();
    }
}
