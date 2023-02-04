package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AppointmentPage {

    WebDriver driver;
    WebDriverWait wait;
    By makeAppointmentButtonLocator = By.id("btn-make-appointment");
    By headerLocator = By.id("top");
    By facilityDropdownLocator = By.id("combo_facility");
    By hospitalReadmissionCheckboxLocator = By.name("hospital_readmission");
    By medicaidRadioLocator = By.id("radio_program_medicaid");
    By visitDateInputLocator = By.id("txt_visit_date");
    By bookAppointmentButtonLocator = By.id("btn-book-appointment");

    public AppointmentPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void loadAppointmentPage() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.loadLoginPage();
        loginPage.login("John Doe", "ThisIsNotAPassword");
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
        System.out.println("Appointment booking page loaded properly and the header is displayed.");
    }

    public void selectHongkongCenterFromDropdown(){
        Select facilityDropdown = new Select(driver.findElement(facilityDropdownLocator));
        facilityDropdown.selectByValue("Hongkong CURA Healthcare Center");
        System.out.println("Hongkong CURA Healthcare Center selected.");
    }

    public void checkHospitalReadmissionCheckbox(){
        WebElement hospitalReadmissionCheckbox = driver.findElement(hospitalReadmissionCheckboxLocator);
        hospitalReadmissionCheckbox.click();
        System.out.println("Applied for hospital readmission.");
    }

    public void setMedicaidRadioButton(){
        WebElement medicaidRadio = driver.findElement(medicaidRadioLocator);
        medicaidRadio.click();
        System.out.println("Medicaid radio selected.");
    }

    public void setVisitDate(String visitDate){
        WebElement visitDateInputField = driver.findElement(visitDateInputLocator);
        visitDateInputField.sendKeys(visitDate);
        System.out.println("Visit date set to " + visitDate);
    }

    public void clickBookAppointmentButton(){
        WebElement bookAppointmentButton = driver.findElement(bookAppointmentButtonLocator);
        bookAppointmentButton.click();
        System.out.println("Book Appointment button is clicked.");
    }
}
