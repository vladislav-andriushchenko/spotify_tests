package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserStackConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserStackDriver implements WebDriverProvider {

    private static final BrowserStackConfig config = ConfigFactory.create(BrowserStackConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        DesiredCapabilities caps = new DesiredCapabilities();

        Map<String, Object> networkLogsOptions = new HashMap<>();
        networkLogsOptions.put("captureContent", true);

        Map<String, Object> bstackOptions = new HashMap<>() {{
            put("userName", config.user());
            put("accessKey", config.key());
            put("projectName", "Todoist Project");
            put("buildName", "Android Build");
            put("sessionName", "Mobile Tests");
            put("appiumLogs", "true");
            put("networkLogs", "true");
            put("networkLogsOptions", networkLogsOptions);
        }};

        caps.setCapability("platformName", "android");
        caps.setCapability("deviceName", config.androidDevice());
        caps.setCapability("platformVersion", config.androidOsVersion());
        caps.setCapability("app", config.app());
        caps.setCapability("bstack:options", bstackOptions);

        try {
            System.out.println("Creating BrowserStack session with capabilities: " + caps);
            return new AndroidDriver(
                    new URL("https://hub.browserstack.com/wd/hub"),
                    caps
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to create BrowserStack driver", e);
        }
    }
}