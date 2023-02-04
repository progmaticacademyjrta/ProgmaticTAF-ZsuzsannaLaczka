package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends DriverBaseTest {

    LoginPage loginPage;

    @Test(groups = "regression", description = "TC01: Login page loaded properly.")
    public void loginPageLoadedTest(){
        loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
    }

    @Test(groups = "regression", description = "TC02: Try login with valid username and wrong password.")
    public void validUsernameWrongPwdTest(){
        loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.login("John Doe", "wrong password");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-danger")));
        Assert.assertEquals(driver.findElement(By.className("text-danger")).getText(),
                "Login failed! Please ensure the username and password are valid.");
        System.out.println("Login is not successful with valid username and wrong password, error message displays.");
    }

}
