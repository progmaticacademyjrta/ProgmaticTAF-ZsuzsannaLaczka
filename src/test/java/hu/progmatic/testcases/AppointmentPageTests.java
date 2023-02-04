package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AppointmentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppointmentPageTests extends DriverBaseTest {

    AppointmentPage appointmentPage;

    @Test(description = "TC01: Appointment booking page loads properly and the header is displayed.")
    public void appointmentPageLoadedTest(){
        appointmentPage = new AppointmentPage(driver, wait);
        appointmentPage.loadAppointmentPage();
    }

    @Test(description = "TC02: Appointment booking works with filling required fields.")
    public void appointmentBookingWorksTest(){
        appointmentPage = new AppointmentPage(driver, wait);
        appointmentPage.loadAppointmentPage();
        appointmentPage.selectHongkongCenterFromDropdown();
        appointmentPage.checkHospitalReadmissionCheckbox();
        appointmentPage.setMedicaidRadioButton();
        appointmentPage.setVisitDate("12/02/2023");
        appointmentPage.clickBookAppointmentButton();
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("col-xs-12"))).getText(),
                "Appointment Confirmation\n" +
                        "Please be informed that your appointment has been booked as following:");
        System.out.println("Appointment booking confirmed.");
    }
}
