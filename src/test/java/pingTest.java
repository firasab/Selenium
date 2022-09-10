import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class pingTest {

    @Test
    public void testBing() throws InterruptedException{
        WebDriver driver = OpenBrowserByPara.openBrowser("chrome");
        driver.get("https://ww.bing.com/");
        Thread.sleep(10000);
        WebElement search = driver.findElement(By.name("q"));
        String searchText = "Selenium";
        search.sendKeys(searchText);
        WebElement button = driver.findElement(By.xpath("//*[@id=\"search_icon\"]"));
        button.click();

        List<WebElement> l=driver.findElements(By.xpath("//*[@id=\"b_results\"]/li[1]/div[1]/h2/a"));
        if(l.size() !=0){
            String title = driver.findElement(By.xpath("//*[@id=\"b_results\"]/li[1]/div[1]/h2/a")).getText();
            System.out.println(title);
            assertEquals(title, searchText);
        }
        else {
            String title = driver.findElement(By.xpath("//*[@id=\"b_results\"]/li[1]/h2/a")).getText();
            System.out.println(title);
            assertEquals(title, searchText);
        }
    }




}
