package XML_DENEME.odev4;

import org.openqa.selenium.By;

public class Locators {
    public static final String siteTitle = "OrangeHRM";
    public static final String myUsername = "admin";
    public static final String myPassword = "admin123";
    public static final By notificationMessage = By.cssSelector(".oxd-input-field-error-message");
    public static final String INPUT = "//label[contains(text(),'%s')]/ancestor::div[starts-with(@class,'oxd-input-group')]//input";
    public static final String DROPDOWN = "//label[contains(text(),'%s')]/ancestor::div[starts-with(@class,'oxd-grid-item')]//div[@class='oxd-select-wrapper']";
    public static final String DROPDOWN_OPTION = "//div[@role='option' and .//*[contains(.,'%s')]]";
    public static final String BUTTON = "//button[contains(., '%s')]";
    public static final String MENU_LINK = "//aside//a[contains(., '%s')]";
    public static final String NOTIFICATION = "//div[contains(@class,'oxd-toast-container') and ./*[contains(.,'%s')]]";
    public static final String TABLE_DELETE_BUTTON = "//div[@class='oxd-table-card' and .//div[contains(@class,'oxd-table-cell') and contains(., '%s')]]//button[1]";
    public static final String TABLE_EDIT_BUTTON = "//div[@class='oxd-table-card' and .//div[contains(@class,'oxd-table-cell') and contains(., '%s')]]//button[2]";

    public static By xpath(String xpathStr, String label) {
        return By.xpath(String.format(xpathStr, label));
    }

    public static By xpath(By locator) {
        return locator;
    }
}
