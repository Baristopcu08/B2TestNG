package gun05.odev2;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public enum Elements {
    INPUT("//label[contains(text(),'%s')]/ancestor::div[starts-with(@class,'oxd-input-group')]//input"),
    DROPDOWN("//label[contains(text(),'%s')]/ancestor::div[starts-with(@class,'oxd-grid-item')]//div[@class='oxd-select-wrapper']"),
    DROPDOWN_OPTION("//div[@role='option' and .//*[contains(.,'%s')]]"),
    BUTTON("//button[contains(., '%s')]"),
    MENU_LINK("//aside//a[contains(.,'%s')]"),
    TABLE_DELETE_BUTTON("//div[@class='oxd-table-card' and .//div[contains(@class,'oxd-table-cell') and contains(., '%s')]]//button[1]"),
    TABLE_EDIT_BUTTON("//div[@class='oxd-table-card' and .//div[contains(@class,'oxd-table-cell') and contains(., '%s')]]//button[2]")
    ;

    private final String xpathString;
    private By xpath;

    Elements(String xpathString) {
        this.xpathString = xpathString;
    }

    public By getXpath() {
        return xpath;
    }

    public Elements of(String label){
        xpath = By.xpath(String.format(xpathString, label));
        return this;
    }

    public void click(){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(xpath)).click();
    }

    public void sendkeys(CharSequence...string){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(xpath)).sendKeys(string);
    }


}
