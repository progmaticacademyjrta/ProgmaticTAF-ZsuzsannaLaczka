package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends DriverBaseTest {
    HomePage homePage;

    @Test(groups = "regression", description = "TC01: Homepage loaded test that loads the page and validates whether the header is displayed or not.")
    public void homepageLoadedTest() {
        homePage = new HomePage(driver, wait);
        homePage.loadHomePage();
    }

    @Test(groups = "regression", description = "TC02: Make Appointment button is clickable and navigates to the Login page.")
    public void makeAppointmentButtonIsClickableTest(){
        homePage = new HomePage(driver, wait);
        homePage.makeAppointmentButtonClick();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");
        System.out.println("Make Appointment button navigates to the Login page.");
    }


}
