package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/browserstack.properties")

public interface BrowserStackConfig extends Config {
    @Key("browserstack.user")
    String user();

    @Key("browserstack.key")
    String key();

    @Key("browserstack.url")
    String url();

    @Key("browserstack.app")
    String app();

    @Key("device.android")
    String androidDevice();

    @Key("os.android")
    String androidOsVersion();
}