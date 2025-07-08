package extensions;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;


import java.util.Map;

public class LoginExtension implements BeforeEachCallback {

    private static final String AUTH_TOKEN = "4d576c4dfa61b2bd2c14375ddbc4761343bb2786";

    @Override
    public void beforeEach(ExtensionContext context) {
        AndroidDriver driver = (AndroidDriver) WebDriverRunner.getWebDriver();

        // Inject token into SharedPreferences
        driver.executeScript("mobile: shell", Map.of(
                "command", "echo \"<string name=\\\"auth_token\\\">"
                        + AUTH_TOKEN
                        + "</string>\" > /data/data/com.todoist/shared_prefs/auth.xml"
        ));

        // Optionally restart app here to apply auth state
    }
}