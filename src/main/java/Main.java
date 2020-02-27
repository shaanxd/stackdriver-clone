import observable.Observable;
import repository.config.ConfigurationRepository;
import repository.config.FileConfigurationRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Read the file using ConfigRepository
        ConfigurationRepository configurationRepository = new FileConfigurationRepository("src/main/java/files/config.json");
        List<Observable> observables = configurationRepository.readConfigurations();

        for (Observable observable : observables) {
            observable.readContent();
        }
    }
}
