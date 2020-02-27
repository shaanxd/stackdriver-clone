package notification;

public abstract class AbstractNotification implements Notification {
    protected String value;

    public AbstractNotification(String value) {
        this.value = value;
    }
}
