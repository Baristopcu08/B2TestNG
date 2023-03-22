package gun06.POM;

import org.openqa.selenium.By;

import java.text.MessageFormat;

public class Locators {

    public static String ALL_BUTTON_INPUT="//button[contains(.,\"{0}\")] | //input[@type='button' and contains(text(),\"{0}\")]";
    public static String ALL_DIV="//div[@class=\"{0}\"]";
    public static String ALL_LI="//li[@class=\"{0}\"]";
    public static final String ALL_A="//a[normalize-space()=\"{0}\"]";
    public static final String ALLSPAN="//span[contains(text(),\"{0}\")]";

    public static By xpath(String xpathstr,String label){
        return By.xpath(MessageFormat.format(xpathstr,label));

    }
    public static By xpath(String xpathstr,int index){
        return By.xpath(MessageFormat.format(xpathstr,index));

    }
    public static By xpath(String locator){
        return By.xpath(locator);
    }


}
