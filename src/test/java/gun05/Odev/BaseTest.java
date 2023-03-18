package gun05.Odev;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.MessageFormat;
import java.util.Random;

import static gun05.Odev.Locators.*;
import static gun05.Odev.Locators.lList;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;




    protected void changeUsarname(String oldUsarName,String newUsarname){
        click_2(lList,oldUsarName);
        click(lUsarnameChance);
        new Actions(driver).sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE).build().perform();
        new Actions(driver).sendKeys(newUsarname).build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click_2(ALL_CLICK_LOCATOR,"Save");
    }

    protected void SerchUsarname(String usarname) {
        wait_URL_Contains("viewSystemUsers");      //admin page control
        sendKeys(lUsarnameSearch,usarname);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        click_2(ALL_CLICK_LOCATOR,"Search");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MessageFormat.format(lList,usarname))));
    }

    protected void wait_URL_Contains(String url_text){
        wait.until(ExpectedConditions.urlContains(url_text));
    }

    protected void click_2(String locator,String locatorName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MessageFormat.format(locator,locatorName))));
        click(By.xpath(MessageFormat.format(locator,locatorName)));

    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    protected void sendKeys(By locator,String text) {
        sendKeys(driver.findElement(locator),text);
    }
    protected void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    protected static String randomText() {
        int leftLimit = 97; // harf "a"nın ASCII kodu
        int rightLimit = 122; // harf "z"nin ASCII kodu
        int targetStringLength = 5;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }
}
