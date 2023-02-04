package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AppointmentPage;
import hu.progmatic.pages.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTests extends DriverBaseTest {

    AppointmentPage appointmentPage;
    ProfilePage profilePage;

    @Test(description = "TC01: Login, appointment booking and logout works together smoothly.")
    public void loginBookingLogoutTest(){
        appointmentPage = new AppointmentPage(driver, wait);
        appointmentPage.loadAppointmentPage();
        appointmentPage.selectHongkongCenterFromDropdown();
        appointmentPage.checkHospitalReadmissionCheckbox();
        appointmentPage.setMedicaidRadioButton();
        appointmentPage.setVisitDate("12/02/2023");
        appointmentPage.clickBookAppointmentButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("col-xs-12")));
        appointmentPage.logout();
        System.out.println("Login, appointment booking and logout works together smoothly.");
    }
}
