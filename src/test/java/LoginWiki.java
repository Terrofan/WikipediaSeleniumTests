import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginWiki extends TestBase{
@Test
public void openWikipediaTest() throws InterruptedException {
    openSite("https://www.wikipedia.org/");
    selectLang("en");
    init_login();
    fillLoginForm("Nikita", "Shirman");
    driver.findElement(By.id("wpLoginAttempt")).click();
}

}
