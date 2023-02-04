package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;
    By makeAppointmentButtonLocator = By.id("btn-make-appointment");
    By usernameInputLocator = By.id("txt-username");
    By pwdInputLocator = By.id("txt-password");
    By loginButtonLocator = By.id("btn-login");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void loadLoginPage(){
        driver.get("https://katalon-demo-cura.herokuapp.com");
        WebElement makeAppointmentButton = driver.findElement(makeAppointmentButtonLocator);
        makeAppointmentButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");
        System.out.println("Login page loaded properly.");
    }

    public void login(String username, String password){
        WebElement usernameInputField = driver.findElement(usernameInputLocator);
        usernameInputField.sendKeys(username);
        WebElement pwdInputField = driver.findElement(pwdInputLocator);
        pwdInputField.sendKeys(password);
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
        System.out.println("Username and password fields filled and Login button clicked.");
    }
}
