package observable;

import log.Log;
import log.LogFactory;
import observer.Observer;
import repository.content.ContentRepository;
import repository.content.FileContentRepository;

import java.util.ArrayList;
import java.util.List;

public class ApplicationObservable implements Observable {
    private String filePath;
    private String name;
    private List<Observer> observers = new ArrayList<>();

    public ApplicationObservable(String filePath, String name) {
        this.filePath = filePath;
        this.name = name;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void readContent() {
        ContentRepository contentRepository = new FileContentRepository(this.filePath);
        List<String> lines = contentRepository.readLogs();

        List<Log> logs = new ArrayList<>();
        LogFactory logFactory = new LogFactory(this.name, this.observers);

        for (String line : lines) {
            Log log = logFactory.getInstance(line);
            if (log != null) {
                logs.add(log);
            }
        }
        for (Log log : logs) {
            log.alert();
        }
    }

    @Override
    public String toString() {
        return "ApplicationObservable{" +
                "filePath='" + filePath + '\'' +
                ", name='" + name + '\'' +
                ", observers=" + observers +
                '}';
    }
}
