package task1;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginSpec extends LoginPage {
  private static String OKUsername = System.getProperty("OK.username", "technopolisbot");
  private static String OKPassword = System.getProperty("OK.password", "technopolis16");
  private static String OKName = System.getProperty("OK.idName", "technopolisbot technopolisbot");



  @Test
  public void LoginShowsCorrectName() {
    login(OKUsername,OKPassword);
    $(By.xpath("//*[@id=\'hook_Block_Navigation\']/div/div/div[1]/a/div"))
            .shouldHave(text(OKName))
            .shouldBe(visible);
  }

}
