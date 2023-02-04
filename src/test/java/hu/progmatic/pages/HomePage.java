package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    By headerBy = By.id("top");
    By makeAppointmentButtonLocator = By.id("btn-make-appointment");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void loadHomePage() {
        driver.get("https://katalon-demo-cura.herokuapp.com");
        WebElement headerElement = driver.findElement(headerBy);
        Assert.assertTrue(headerElement.isDisplayed());
        System.out.println("Homepage loaded properly.");
    }

    public void makeAppointmentButtonClick(){
        WebElement makeAppointmentButton = driver.findElement(makeAppointmentButtonLocator);
        Assert.assertTrue(makeAppointmentButton.isEnabled());
        makeAppointmentButton.click();
        System.out.println("Make Appointment button is clickable.");
    }
}
