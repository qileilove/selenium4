import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class RelativeLocators {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://automationbookstore.dev/");
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
      
        driver.close();
    }

    @Test(description = "Test book5 is left of book6 and Below of book1")
    public void toLeftOfAndBelow(){
        WebElement book5 = driver.findElement(RelativeLocator.withTagName("li").toLeftOf(By.id("pid6")).below(By.id("pid1")));
        String id = book5.getAttribute("id");
        System.out.println("ID of book5: " + id);
        Assert.assertEquals("pid5",id);
    }

    @Test(description = "Test book3 is above book7 and right of book2")
    public void aboveAndToRightOf(){
        WebElement book3 = driver.findElement(RelativeLocator.withTagName("li").above(By.id("pid7")).toRightOf(By.id("pid2")));
        String id = book3.getAttribute("id");
        System.out.println("ID of book3: " + id);
        Assert.assertEquals("pid3", id);
    }

    /*
   @Test(description = "Test book5 is left of book6 and Below of book1")
    public void toLeftOfAndBelow(){
        WebElement book5 = driver.findElement(withTagName("li").toLeftOf(By.id("pid6")).below(By.id("pid1")));
        String id = book5.getAttribute("id");
        System.out.println("ID of book5: " + id);
        Assert.assertEquals("pid5",id);
    }

    @Test(description = "Test book3 is above book7 and right of book2")
    public void aboveAndToRightOf(){
        WebElement book3 = driver.findElement(withTagName("li").above(By.id("pid7")).toRightOf(By.id("pid2")));
        String id = book3.getAttribute("id");
        System.out.println("ID of book3: " + id);
        Assert.assertEquals("pid3", id);
    }
    */

}
