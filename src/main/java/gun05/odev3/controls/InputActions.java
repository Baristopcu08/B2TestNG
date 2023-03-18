package gun05.odev3.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class InputActions {

    private static final String XPATH = "//label[contains(text(),'%s')]/ancestor::div[starts-with(@class,'oxd-input-group')]//input";

    private static By locator(String text){
        return By.xpath(String.format(XPATH, text));
    }

    public static void click(String text) {
        click(locator(text), 10);
    }

    public static void click(By locator, int waitSeconds) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(waitSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public static void sensKeys(String label, CharSequence...text) {
        sensKeys(locator(label), text);
    }

    public static void sensKeys(By locator, CharSequence...text) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
    }

}
