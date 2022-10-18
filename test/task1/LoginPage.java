package task1;

import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;

import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public abstract class LoginPage {

  @Rule
  public ScreenShooter screenShooter = ScreenShooter.failedTests();

  @BeforeClass
  public static void openInbox() {
    timeout = 10000;
    baseUrl = "https://ok.ru/";
    startMaximized = false;
    browser = "chrome";
    browserPosition = "890x10";
    browserSize = "780x950";
    addListener(new Highlighter());
    
    open("/");
    waitUntilPagesIsLoaded();
  }

  protected static void waitUntilPagesIsLoaded() {
    $(byText("Loading")).waitUntil(disappears, 20000);
  }

  @AfterClass
  public static void logout() {
    closeWebDriver();
  }

  public static void login(String OKUsername,String OKPassword) {
    $("#field_email.it.h-mod").val(OKUsername);
    $("#field_password.it").val(OKPassword).pressEnter();
  }
}
