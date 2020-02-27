package notification;

public class MessageNotification extends AbstractNotification {
    public MessageNotification(String value) {
        super(value);
    }

    @Override
    public void push(String message) {
        System.out.println("MESSAGING " + this.value + " ON " + message);
    }
}
