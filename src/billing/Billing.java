package billing;

import model.Subscription;
import service.NotificationService;

public class Billing {

    private static int totalSubscribersCount = 0;
    private static double totalRevenue = 0.0;

    private final NotificationService notificationService;

    public Billing(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void processPayment(Subscription sub, String contact, double finalPrice) {
        if (sub == null || finalPrice <= 0) {
            System.out.println(
                    "[WARNING] Оплата не зарегистрирована: некорректные данные."
            );
            return;
        }

        totalSubscribersCount++;
        totalRevenue += finalPrice;

        String message = String.format(
                "Оплата подписки \"%s\" прошла успешно. Сумма: %.2f руб.",
                sub.getName(),
                finalPrice
        );

        notificationService.sendNotification(message, contact);
        System.out.printf("Оплата зарегистрирована: %.2f руб.%n", finalPrice);
    }

    public static int getTotalSubscribersCount() {
        return totalSubscribersCount;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static void printGlobalStats() {
        System.out.println("\n========== ОБЩАЯ СТАТИСТИКА ==========");
        System.out.println("Количество оплат: " + totalSubscribersCount);
        System.out.printf("Общая выручка: %.2f руб.%n", totalRevenue);
        System.out.println("======================================");
    }
}
