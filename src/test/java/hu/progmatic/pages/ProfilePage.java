package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfilePage {

    WebDriver driver;
    WebDriverWait wait;

    By menuIconLocator = By.className("toggle");
    By profileMenuIconLocator = By.linkText("Profile");
    By logoutButtonLocator = By.linkText("Logout");

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void loadProfilePage(){
        AppointmentPage appointmentPage = new AppointmentPage(driver, wait);
        appointmentPage.loadAppointmentPage();
        WebElement menuIcon = driver.findElement(menuIconLocator);
        menuIcon.click();
        WebElement profileMenuIcon = driver.findElement(profileMenuIconLocator);
        profileMenuIcon.click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButtonLocator)).isDisplayed());
        System.out.println("Profile page loaded properly and Logout button is displayed.");
    }

    public void logout(){
        WebElement logoutButton = driver.findElement(logoutButtonLocator);
        logoutButton.click();
        System.out.println("Logout button clicked.");
    }
}
