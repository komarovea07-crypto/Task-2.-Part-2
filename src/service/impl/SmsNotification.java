package service.impl;

import service.NotificationService;

public class SmsNotification implements NotificationService {

    @Override
    public void sendNotification(String message, String recipient) {
        if (recipient == null
                || !(recipient.startsWith("+7") || recipient.startsWith("8"))
                || recipient.length() < 11) {
            System.out.println(
                    "[WARNING] Некорректный номер телефона: " + recipient
            );
            return;
        }

        System.out.println(
                "[SMS] На номер " + recipient
                        + " отправлено сообщение: " + message
        );
    }
}
