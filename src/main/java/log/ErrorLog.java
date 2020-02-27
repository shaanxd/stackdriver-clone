package log;

import observer.Observer;

import java.util.List;

public class ErrorLog extends AbstractLog {
    public ErrorLog(String message, String date, String name, List<Observer> observers) {
        super(message, date, name, observers);
    }

    @Override
    public void alert() {
        String alertMessage = "ERROR OCCURRED @" + this.name + " ON " + this.date + " @MESSAGE " + this.message;

        for (Observer observer : this.observers) {
            observer.alert(alertMessage);
        }
    }
}
