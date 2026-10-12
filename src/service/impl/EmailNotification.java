package service.impl;

import service.NotificationService;

public class EmailNotification implements NotificationService {

    @Override
    public void sendNotification(String message, String recipient) {
        if (recipient == null || !recipient.contains("@")
                || !recipient.substring(recipient.indexOf("@")).contains(".")) {
            System.out.println(
                    "[WARNING] Некорректный адрес электронной почты: " + recipient
            );
            return;
        }

        System.out.println(
                "[EMAIL] На адрес " + recipient
                        + " отправлено письмо: " + message
        );
    }
}
