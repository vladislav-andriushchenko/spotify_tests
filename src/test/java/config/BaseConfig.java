package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources("classpath:config/local.properties")
public interface BaseConfig extends Config {
    @Key("baseUrl")
    String baseUrl();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("email")
    String email();

    @Key("password")
    String password();

    static BaseConfig getInstance() {
        return ConfigFactory.create(BaseConfig.class);
    }
}