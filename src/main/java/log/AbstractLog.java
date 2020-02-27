package log;

import observer.Observer;

import java.util.List;

public abstract class AbstractLog implements Log {
    protected String message;
    protected String date;
    protected String name;
    protected List<Observer> observers;

    public AbstractLog(String message, String date, String name, List<Observer> observers) {
        this.message = message;
        this.date = date;
        this.name = name;
        this.observers = observers;
    }
}
