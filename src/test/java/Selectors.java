import org.testng.annotations.Test;

public class Selectors extends TestBase {

    @Test
    public void WikiElementsTest() throws InterruptedException {
        openSite("https://wikipedia.org/");
        selectLang("en");
        returnBack();
        selectLang("ru");
    }


}

