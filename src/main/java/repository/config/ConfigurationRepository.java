package repository.config;

import observable.Observable;

import java.util.List;

public interface ConfigurationRepository {
    List<Observable> readConfigurations();
}
