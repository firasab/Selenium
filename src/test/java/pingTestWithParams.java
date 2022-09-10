import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class pingTestWithParams {
    WebDriver driver = OpenBrowserByPara.openBrowser("chrome");

    @BeforeSuite
    public void beforeSuite(){
        driver.get("https://ww.bing.com/");
    }


    @Parameters({"searchtitlle", "expectedTittle"})
    @Test
    public void testBingWithParams(String searchtitlle , String expectedTittle) throws InterruptedException{
        Thread.sleep(10000);
        WebElement search = driver.findElement(By.name("q"));
        String searchText = searchtitlle;
        search.sendKeys(searchText);
        WebElement button = driver.findElement(By.xpath("//*[@id=\"search_icon\"]"));
        button.click();

        List<WebElement> l=driver.findElements(By.xpath("//*[@id=\"b_results\"]/li[1]/div[1]/h2/a"));
        if(l.size() !=0){
            String title = driver.findElement(By.xpath("//*[@id=\"b_results\"]/li[1]/div[1]/h2/a")).getText();
            System.out.println(title);
            assertEquals(title, searchText);
            driver.navigate().back();
        }
        else {
            String title = driver.findElement(By.xpath("//*[@id=\"b_results\"]/li[1]/h2/a")).getText();
            System.out.println(title);
            assertEquals(title, searchText);
            driver.navigate().back();
        }
    }
}




