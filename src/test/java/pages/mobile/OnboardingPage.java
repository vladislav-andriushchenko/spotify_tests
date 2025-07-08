package pages.mobile;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class OnboardingPage {

    private final SelenideElement logo = $(id("com.todoist:id/logo")),
            mainEmailButton = $(id("com.todoist:id/btn_email")),
            nestedEmailButton = $(id("com.todoist:id/email_login")),
            passwordInput = $(AppiumBy.xpath("//android.widget.EditText[.//android.widget.TextView[@text='Your password']]")),
            emailInput = $(AppiumBy.xpath("//android.widget.EditText[.//android.widget.TextView[@text='Your email']]")),
            loginButton = $(AppiumBy.xpath("//android.view.View[@resource-id='auth_button_tag']")),
            neverAskButtonTimezone = $(AppiumBy.id("android:id/button3")),
            todayOptionToolBar = $(AppiumBy.xpath("//android.widget.TextView[@text='Today']"));

    public void checkLogo() {
        logo.shouldBe(visible);
    }

    public void checkTodayOption() {
        todayOptionToolBar.shouldBe(visible);
    }

    public OnboardingPage selectLoginWithEmail() {
        mainEmailButton.click();
        nestedEmailButton.click();
        return this;
    }

    public OnboardingPage enterEmail(String value) {
        emailInput.sendKeys(value);
        return this;
    }

    public OnboardingPage enterPassword(String value) {
        passwordInput.sendKeys(value);
        return this;
    }

    public void clickLogin() {
        loginButton.click();
    }

    public OnboardingPage removeTimezonePopup() {
        neverAskButtonTimezone.click();
        return this;
    }
}
