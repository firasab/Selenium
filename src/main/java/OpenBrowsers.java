import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

    public class OpenBrowsers {
        public static WebDriver openBrowser(String browser) {

            WebDriver driver;
            if(browser.equals("firefox")) {
                //Setting webdriver.gecko.driver property
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Public\\Desktop\\Selenium_task\\src\\main\\resources\\geckodriver.exe");

                //Instantiating driver object and launching browser
                driver = new FirefoxDriver();
            }else if(browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Public\\Desktop\\Selenium_task\\src\\main\\resources\\chromedriver.exe");

                //Instantiating driver object
                driver = new ChromeDriver();
            }else if(browser.equals("edge")) {
                System.setProperty(
                        "webdriver.edge.driver",
                        "C:\\Users\\Public\\Desktop\\Selenium_task\\src\\main\\resources\\msedgedriver.exe");
                // Instantiate a ChromeDriver class.
                driver = new EdgeDriver();
            }else {
                driver = null;
            }

            return driver;
        }

        public static void main(String[] args) throws InterruptedException {
            String[] browsers = {"firefox","chrome","edge"};
            for(int i =0;i<browsers.length;i++) {
                WebDriver driver = OpenBrowsers.openBrowser(browsers[i]);
                driver.get("https://www.google.com/");
                driver.manage().window().maximize();
                driver.get("https://www.bing.com//");
                driver.navigate().back();
                driver.navigate().forward();



                Thread.sleep(10000);
                driver.quit();
            }
        }
    }

