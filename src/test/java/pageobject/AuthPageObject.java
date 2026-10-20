package pageobject;

import elements.Auth;
import factory.ConfigReader;
import factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Locale;

public class AuthPageObject {
    private final WebDriver driver = DriverFactory.getDriver();

    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void openRegistrationPage() {
//        WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Auth.register_element)).click();
        WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(Auth.registerPageHeading));
        String heading = until.getText().trim();
        Assert.assertEquals(heading, "Create an Account", "Something went wrong.");
    }

    public void open() throws InterruptedException {
        String baseUrl = ConfigReader.get("base.url");
        driver.get(baseUrl);
    }

    public void enterValidUserDetailsForRegistration(String email, String phone, String username, String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Auth.email));
        WebElement emailInput = driver.findElement(Auth.email);
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement phoneInput = driver.findElement(Auth.phone);
        phoneInput.clear();
        phoneInput.sendKeys(phone);

        WebElement userInput = driver.findElement(Auth.username);
        userInput.clear();
        userInput.sendKeys(username);

        WebElement passwordInput = driver.findElement(Auth.password);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement confirmPasswordInput = driver.findElement(Auth.confirmPassword);
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(password);
    }

}
