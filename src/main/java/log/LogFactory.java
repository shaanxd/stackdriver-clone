package log;

import observer.Observer;

import java.util.List;

public class LogFactory {
    private String appName;
    private List<Observer> observers;

    public LogFactory(String appName, List<Observer> observers) {
        this.appName = appName;
        this.observers = observers;
    }

    public Log getInstance(String log) {
        Log logInstance = null;

        String[] logContent = log.split("-");

        String severity = logContent[0];
        String date = logContent[1];
        String message = logContent[2];

        switch (severity) {
            case "ERROR":
                logInstance = new ErrorLog(message, date, this.appName, this.observers);
                break;
        }

        return logInstance;
    }
}
