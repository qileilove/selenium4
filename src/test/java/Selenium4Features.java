import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Selenium4Features {

   //@Test
    public void screenshotTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        WebElement logo = driver.findElement(By.xpath("//img[@alt='My Store']"));

        File file = logo.getScreenshotAs(OutputType.FILE);
        File destFile = new File("logo.png");
        FileUtils.copyFile(file,destFile);

        driver.quit();
    }

   // @Test
    public void openNewTab() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("http://demoqa.com/");

        Thread.sleep(5000);

        driver.quit();
    }
    //@Test
    public void openNewWindow() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("http://demoqa.com/");

        Thread.sleep(5000);

        driver.quit();
    }

    @Test
    public void location(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        WebElement logo = driver.findElement(By.xpath("//img[@alt='My Store']"));
        System.out.println("Height: " + logo.getRect().getDimension().getHeight());
        System.out.println("Width: " + logo.getRect().getDimension().getWidth());

        System.out.println("X Position: " + logo.getRect().getX());
        System.out.println("Y Position: " + logo.getRect().getY());

        driver.quit();
    }
}
