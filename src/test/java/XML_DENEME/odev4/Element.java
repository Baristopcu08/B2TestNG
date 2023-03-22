package XML_DENEME.odev4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Element {

    protected  static  WebDriver driver;
    public static   WebDriverWait wait;

    private By locator;
    private WebElement element;

    public static Element $(By locator){
        return new Element(locator);
    }

    private Element(By locator){
        this.locator = locator;
        element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public Element() {
    }

    public static void open(String url){
        new Element()._open(url);
    }

    public void _open(String url){
        driver.get(url);
    }

    public void click(){
        element.click();
    }

    public Element sendKeys(CharSequence...text){
        element.sendKeys(text);
        return this;
    }

    public Element shouldBe(Conditions condition){
        switch (condition){
            case visible:
                element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;
            case clickable:
                element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                break;
            case invisible:
                wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
                return null;
            default:
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                break;
        }
        return this;
    }

    public Element textShouldBe(String text){
        wait.until(driver1 -> {
            try{
                if (!driver1.findElement(locator).getText().equalsIgnoreCase(text))
                    throw new Exception();
                return true;
            }catch (Exception e){
                return false;
            }
        });
        return this;
    }

    public Element shouldContainsText(String text){
        wait.until(d -> {
            try{
                if (!driver.findElement(locator).getText().toLowerCase().contains(text.toLowerCase()))
                    throw new Exception();
                return true;
            }catch (Exception e){
                return false;
            }

        });
        return this;
    }

    public static void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
