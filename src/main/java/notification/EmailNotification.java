package notification;

public class EmailNotification extends AbstractNotification {
    public EmailNotification(String value) {
        super(value);
    }

    @Override
    public void push(String message) {
        System.out.println("EMAILING " + this.value + " ON " + message);
    }
}
