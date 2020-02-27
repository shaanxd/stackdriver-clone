package observer;

import notification.Notification;

import java.util.ArrayList;
import java.util.List;

public class SystemAdminObserver implements Observer {
    private String name;
    private List<Notification> notifications = new ArrayList<>();

    public SystemAdminObserver(String name) {
        this.name = name;
    }

    @Override
    public void alert(String message) {
        for (Notification notification : notifications) {
            notification.push(message);
        }
    }

    @Override
    public void addNotification(Notification notification) {
        notifications.add(notification);
    }
}
