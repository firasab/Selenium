import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class browserTest {

    @Parameters({"browser"})
    @Test
    public void testBrowser(String browser) throws InterruptedException {

        WebDriver driver = OpenBrowserByPara.openBrowser(browser);

            driver.get("https://www.google.com/");
            driver.manage().window().maximize();

            driver.get("https://www.bing.com//");

            driver.navigate().back();
            driver.navigate().forward();


            Thread.sleep(10000);
            driver.quit();
    }
}
