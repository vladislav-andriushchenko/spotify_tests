package tests.mobile;

import extensions.WithLogin;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

@Tag("MOBILE")
public class LoggedInTests extends TestBase {

    @WithLogin
    @Test
    void userCanSeeTodayView() {
        $(AppiumBy.xpath("//android.widget.TextView[@text='Today']")).click();
        // Proceed with test
    }
}
