package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfilePageTests extends DriverBaseTest {

    ProfilePage profilePage;

    @Test(description = "TC01: Profile page loads properly and the Logout button is displayed.")
    public void profilePageLoadedTest(){
        profilePage = new ProfilePage(driver, wait);
        profilePage.loadProfilePage();
    }
}
