package repository.config;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Application;
import models.User;
import notification.Notification;
import notification.NotificationFactory;
import observable.ApplicationObservable;
import observable.Observable;
import observer.Observer;
import observer.SystemAdminObserver;

import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileConfigurationRepository implements ConfigurationRepository {
    private String filePath;

    public FileConfigurationRepository(String filePath) {
        this.filePath = filePath;
    }

    public List<Observable> readConfigurations() {
        List<Observable> observables = new ArrayList<>();
        try {
            // Read content from file and parse from JSON
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            Type contentType = new TypeToken<ArrayList<Application>>() {
            }.getType();
            List<Application> applications = new Gson().fromJson(content, contentType);

            // Iterate through parsed JSON objects and create Observable, Observer and Notification instances
            for (Application application : applications) {
                Observable observable = new ApplicationObservable(application.getLog_file(), application.getApplication_name());
                for (User user : application.getUsers()) {
                    Observer observer = new SystemAdminObserver(user.getName());
                    String[] notificationTypes = user.getNotificationTypes().split(",");
                    NotificationFactory notificationFactory = new NotificationFactory();
                    for (String notificationType : notificationTypes) {
                        Notification notification = notificationFactory.getInstance(notificationType, user.getPhone(), user.getEmail());
                        observer.addNotification(notification);
                    }
                    observable.registerObserver(observer);
                }
                observables.add(observable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return observables;
    }
}
