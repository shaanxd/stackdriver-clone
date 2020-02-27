package notification;

public class NotificationFactory {
    public Notification getInstance(String notificationType, String phone, String email) {
        Notification notification = null;

        switch (notificationType) {
            case "email":
                notification = new EmailNotification(email);
                break;
            case "sms":
                notification = new MessageNotification(phone);
                break;
        }

        return notification;
    }
}
