package configScroll;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverConf {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        if (ConfigClass.startmaximed)
            options.addArguments("--start-maximized");


        driver = new ChromeDriver(options);

        //driver.manage().window().setSize(ConfigClass.dimension);
        //driver.manage().window().setPosition(new Point(10, 10));
        if (ConfigClass.dimension != null && ConfigClass.startmaximed == false) {
            int width = Integer.parseInt(ConfigClass.dimension.split("x")[0]);
            int height = Integer.parseInt(ConfigClass.dimension.split("x")[1]);

            driver.manage().window().setSize(new Dimension(width, height));
        }
        return driver;
    }
}
