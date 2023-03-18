package gün04_Listeners_ScreenShot.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class deneme {
    @Test
    public void testInvalidLogin() {
        // WebDriver'ı başlat
        WebDriverManager.chromedriver().setup();
        ChromeOptions  options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10_000));

        // Web sayfasını aç
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Geçersiz kullanıcı adı ve parola
        String invalidUsername = "invaliduser";
        String invalidPassword = "invalidpass";

        // Kullanıcı adı ve parola alanlarına geçersiz kimlik bilgilerini gir
        WebElement usernameField = driver.findElement(By.cssSelector("input[name=\"username\"]"));
        usernameField.sendKeys(invalidUsername);
        WebElement passwordField = driver.findElement(By.cssSelector("input[name=\"password\"]"));
        passwordField.sendKeys(invalidPassword);

        // Giriş düğmesine tıkla
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        // Hata mesajını doğrula
        WebElement errorMessage = driver.findElement(By.cssSelector("div[role='alert'] div p"));
        String expectedErrorMessage = "Invalid credentials";
        String actualErrorMessage = errorMessage.getText();
        assertEquals(expectedErrorMessage, actualErrorMessage);

        // Tarayıcıyı kapat
        driver.quit();
    }
}
