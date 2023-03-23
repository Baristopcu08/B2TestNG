package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static Utils.Browsers.CHROME;

public class DriverStatic {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        return getDriver(CHROME);
    }

    public static WebDriver getDriver(Browsers browsers){
        if (driver==null){
            switch (browsers){
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case SAFARI:
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("start-maximized"); //ilk açılışta maximize açılır
                    //options.addArguments("user-data");
                    //options.addArguments("user-data-dir=" + System.getProperty("user.home") + "\AppData\Local\Google\Chrome\User Data"); login korumalı sayfada login olmak için
                    //options.addArguments("user-data-dir=C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data"); login korumalı sayfada login olmak için
                    //options.addArguments("--headless");      //Crome arka planda çalışır
                    driver = new ChromeDriver(options);
                    break;
            }
        }

        return driver;
    }


    public static void quitDriver(){

        if (driver!=null) {
            driver.quit();
        }

    }


}
