import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase{
    static WebDriver driver;

    @BeforeSuite
    public void setUp(){
        String browser = System.getProperty("browser", BrowserType.CHROME);
        if(browser.equals(BrowserType.CHROME)){
            driver = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX)){
            driver = new FirefoxDriver();
        }else if(browser.equals(BrowserType.EDGE)){
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    public void openSite(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(3000);
    }

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void selectLang(String local) throws InterruptedException {
        driver.findElement(By.id("js-link-box-" + local)).click();
        Thread.sleep(2000);
    }

    public void init_login() {
        driver.findElement(By.id("pt-login")).click();
    }

    public void fillLoginForm(String user, String password) {
        type(By.id("wpName1"), user);
        type(By.id("wpPassword1"), password);
    }

    public void returnBack() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(2000);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void loginSubmit() {
        click(By.id("wpLoginAttempt"));
    }
}
