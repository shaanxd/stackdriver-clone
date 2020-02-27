package observable;

import observer.Observer;

public interface Observable {
    void registerObserver(Observer observer);

    void readContent();
}
