package gun02.Calisma1;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.Set;

public class Test2 {
//    public static void main(String[] args) {
//        Properties properties = System.getProperties();
//        Set<String> keys = properties.stringPropertyNames();
//        for (String key : keys) {
//            String value = System.getProperty(key);
//            System.out.println(key + " = " + value);
//        }
//    }

//    public static void main(String[] args) {
//        System.getProperties().forEach((k,v)-> System.out.println(k+" : "+v));
//    }



  WebDriver driver;


  By llogin= By.xpath("//li[@class='h-c-header__cta-li h-c-header__cta-li--primary']");
  By lusername= By.xpath("//*[@id=\"identifierId\"]");

    @Test
    public void gmailLogin() {
        driver= Driver.getDriver();
        driver.get("https://myaccount.google.com/?utm_source=sign_in_no_continue&pli=1");
        //driver.findElement(llogin).click();
        //driver.findElement(lusername).sendKeys("baristopcu2008@gmail.com", Keys.ENTER);

    }
}
