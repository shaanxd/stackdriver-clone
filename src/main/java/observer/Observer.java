package observer;

import notification.Notification;

public interface Observer {
    void alert(String message);

    void addNotification(Notification notification);
}
