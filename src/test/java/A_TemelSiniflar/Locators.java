package Odevler.A_TemelSiniflar;

import org.openqa.selenium.By;

import java.text.MessageFormat;

public class Locators {








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
