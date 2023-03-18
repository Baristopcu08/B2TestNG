package gün04_Listeners_ScreenShot.HomeWork2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class Test_1 {

    private WebDriver driver;
    private String baseUrl;
    WebDriverWait wait;





    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--disable-infobars"); //video çekmek için ekledim
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);

        baseUrl = "https://www.google.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(15_000));
        wait=new WebDriverWait(driver,Duration.ofMillis(10_000),Duration.ofMillis(1));

    }

    @Test
    public void gotoURL() {
        driver.get("https://demoqa.com/progress-bar");
    }

    @Test(dependsOnMethods = "gotoURL")
    public void test1() {

        click(Locators.lStartStopButton);
        if (isElementPresent(Locators.lSlidestop)) {
            click(Locators.lStartStopButton);
            screenShot("%60");
        }

        click(Locators.lStartStopButton);
        if (isElementPresent(Locators.lSliderfull)) {
            click(Locators.lResetButton);
            isElementPresent(Locators.lSliderZero);
        }
        screenShot("%0");

    }

    private void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private void screenShot(String name) {

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File ram = screenshot.getScreenshotAs(OutputType.FILE);
        File hard = new File("fotolar/" + name +".png");
        try {
            FileUtils.copyFile(ram,hard);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private boolean isElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
            //driver.findElement(by);
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
