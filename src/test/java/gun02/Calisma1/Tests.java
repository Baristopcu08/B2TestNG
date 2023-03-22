package gun02.Calisma1;
import Utils.Browsers;
import Utils.ThreatDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tests {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeTest
    public void testName() {
         driver= ThreatDriver.getDriver(Browsers.CHROME);
         wait=new WebDriverWait(driver, Duration.ofMillis(10_000));
    }
    @Test()
    public void gotoURL() {

        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @Test(dependsOnMethods = {"gotoURL"})
    public void login() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }





    @AfterTest
    public void tearDown() {
       // driver.quit();
    }
}
