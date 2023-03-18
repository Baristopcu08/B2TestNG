package gun01;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test1 {
    String URL="https://demowebshop.tricentis.com/";
    String myUsername = "abc123@aa.com";
    String myPassword = "123456";
    By lLog_in = By.linkText("Log in");
    By lEmail = By.id("Email");
    By lPassword = By.id("Password");
    By lSubmitButton = By.xpath("//input[@value='Log in']");




    String url = "https://demowebshop.tricentis.com/";

    By lLoginformUsername = By.id("Email");
    By lLoginformPassword = By.id("Password");
    By lLoginformSubmitButton = By.xpath("//input[@value='Log in']");
    By lLogout = By.xpath("//a[text()='Log out']");
    By lLogin = By.xpath("//a[text()='Log in']");


    @Test
    public void gotoUrl(){
        // driver.get
        // title assert edilecek
    }

    @Test
    public void clickLinkLogin(){
        // log in linkine tiklanacak
    }

    @Test
    public void fulfillloginForm(){
        // loginform dolduruacak
    }

    @Test
    public void loginSubmitClick(){
        // loginform click butonuna tiklanacak
    }

    @Test
    public void loginAssert(){
        // login olundugu assert edilecek
    }




}
