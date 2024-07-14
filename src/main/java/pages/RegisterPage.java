package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Locators
    private final By assertRegistrationPageTitle = By.xpath("//h1[text()='Register']");
    private final By registerButton = By.linkText("Register");
    //private final By genderMaleRadioButton = By.id("gender-male");
    private final By genderFemaleRadioButton = By.id("gender-female");
    private final By firstNameField = By.id("FirstName");
    private final By lastNameField = By.id("LastName");
    private final By dayOfBirthField = By.name("DateOfBirthDay");
    private final By monthOfBirthField = By.name("DateOfBirthMonth");
    private final By yearOfBirthField = By.name("DateOfBirthYear");
    private final By emailField = By.id("Email");
    private final By companyField = By.id("Company");
    private final By passwordField = By.id("Password");
    private final By confirmPasswordField = By.id("ConfirmPassword");
    private final By registerSubmitButton = By.id("register-button");
    private final By registerAssertion = By.xpath("//div[@class='result']");
    private final By continueButton = By.xpath("//a[@class='button-1 register-continue-button']");
    private final By logOutButton = By.cssSelector("a[href='/logout']");


    public void register(String firstname, String lastname, String day, String month,
                         String year, String email, String company, String password) {

        //Click on register Button
        driver.findElement(registerButton).click();
        //wait.until(ExpectedConditions.urlContains("/register?returnUrl=%2F"));

        // Assert "Register title Page"
        Assert.assertEquals(driver.findElement(assertRegistrationPageTitle).getText(), "Register");

        // Choose Female/male Gender
        driver.findElement(genderFemaleRadioButton).click();

        //Input firstName
        driver.findElement(firstNameField).sendKeys(firstname);

        //Input lastName
        driver.findElement(lastNameField).sendKeys(lastname);

        //Select day of birth
        wait.until(ExpectedConditions.visibilityOfElementLocated(dayOfBirthField));
        Select selectDay = new Select(driver.findElement(dayOfBirthField));
        selectDay.selectByVisibleText(day);

        //Select  Month of Birth
        wait.until(ExpectedConditions.visibilityOfElementLocated(monthOfBirthField));
        Select selectMonth = new Select(driver.findElement(monthOfBirthField));
        selectMonth.selectByVisibleText(month);

        //Select Year of birth
        wait.until(ExpectedConditions.visibilityOfElementLocated(yearOfBirthField));
        Select selectYear = new Select(driver.findElement(yearOfBirthField));
        selectYear.selectByVisibleText(year);

        //Input Email
        driver.findElement(emailField).sendKeys(email);

        //Input Company Name
        driver.findElement(companyField).sendKeys(company);

        //Input Password
        driver.findElement(passwordField).sendKeys(password);

        //Confirm Password
        driver.findElement(confirmPasswordField).sendKeys(password);

        //Click On register Btn
        wait.until(ExpectedConditions.elementToBeClickable(registerSubmitButton));
        driver.findElement(registerSubmitButton).click();

        //Click on Continue btn
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
        driver.findElement(continueButton).click();

        //Assert success Registration
       // Assert.assertEquals(driver.findElement(registerAssertion).getText(), "Your registration completed");
        //System.out.println(driver.findElement(registerAssertion).getText());
        //Click On Logout Btn
        wait.until(ExpectedConditions.visibilityOfElementLocated(logOutButton));
        driver.findElement(logOutButton).click();
        //Verify navigation to HomePage after logout
        //wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com"));
    }

}



