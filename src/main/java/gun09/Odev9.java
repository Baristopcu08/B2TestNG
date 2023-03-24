package gun09;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

public class Odev9 extends Odev9Base{

    public static By lHome = By.xpath("(//a[contains(.,'Home')])[1]");
    public static By lfirstProduct = By.xpath("//h2[text()='Falcon 9']");
    public static By lConfirm = By.xpath("//h1[text()='Falcon 9']");
    String url = "https://demos.bellatrix.solutions/";

    @Test
    public void gotoURL(){

        driver.get(url);
    }

    @Test(dependsOnMethods = "gotoURL")
    public void Test1(){
        clickMenu1("Home");
        clickMenu1("Blog");
        clickMenu1("Cart");
        clickMenu1("Checkout");
        clickMenu1("Contact Form");
    }



    public void clickMenu(String text) {
        By menuToggleButton = By.cssSelector("#site-navigation-menu-toggle");
        if (driver.findElements(menuToggleButton).size()>0 && driver.findElement(menuToggleButton).isDisplayed()){
            driver.findElement(menuToggleButton).click();
            driver.findElement(By.xpath("(//a[text()='" + text + "'])[2]")).click();
        }else{
            driver.findElement(By.xpath("(//a[text()='" + text + "'])[1]")).click();
        }

    }

    public void clickMenu1(String text) {
        By menuToggleButton = By.cssSelector("#site-navigation-menu-toggle");
        By locator = By.xpath("//a[text()='" + text + "']");
        if (driver.findElements(menuToggleButton).size()>0 && driver.findElement(menuToggleButton).isDisplayed()){
            driver.findElement(menuToggleButton).click();
        }

        driver.findElements(locator)
                .stream()
                .filter(e->e.isDisplayed())
                .collect(Collectors.toList())
                .get(0)
                .click();

    }
}
