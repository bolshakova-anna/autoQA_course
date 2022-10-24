package task1;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class LoginSpec {
  private static String OKUsername = System.getProperty("OK.username", "technoPol27");
  private static String OKPassword = System.getProperty("OK.password", "technoPolis2022");
  private static String OKName = System.getProperty("OK.idName", "technoPol27 technoPol27");

  @Test
  public void LoginShowsCorrectName() {
    LoginPage loginpage = new LoginPage();
    loginpage.openInbox().login(OKUsername,OKPassword);
    $(By.xpath("//div[@class='tico ellip']"))
            .shouldHave(text(OKName))
            .shouldBe(visible);
  }

  @AfterClass
  public static void logout() {
    closeWebDriver();
  }
}
