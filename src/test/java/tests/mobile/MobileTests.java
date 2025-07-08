package tests.mobile;

import config.BaseConfig;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.mobile.OnboardingPage;

import static io.qameta.allure.Allure.step;

@Tag("MOBILE")
public class MobileTests extends TestBase {

    OnboardingPage page = new OnboardingPage();
    private final String EMAIL = BaseConfig.getInstance().email();
    private final String PASSWORD = BaseConfig.getInstance().password();

    @Test
    void onboardingTest() {

        step("Check first screen and select login with email option", () -> {
            page.checkLogo();
            page.selectLoginWithEmail();
        });


        step("Log in", () -> {
            page
                    .enterEmail(EMAIL)
                    .enterPassword(PASSWORD)
                    .clickLogin();
        });


        step("Check home screen", () -> {
            page.removeTimezonePopup();
            page.checkTodayOption();
        });
    }
}
