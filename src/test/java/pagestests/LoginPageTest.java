package pagestests;

import org.testng.annotations.Test;
import pages.LoginPage;
import setup.BaseTest;
import utils.CSVUtils;

public class LoginPageTest extends BaseTest {

    /**
     * Tests the login functionality using data provided from a CSV file.
     *
     * @param firstname The first name of the user (not used in this test).
     * @param lastname  The last name of the user (not used in this test).
     * @param day       The birthday of the user (not used in this test).
     * @param month     The birth month of the user (not used in this test).
     * @param year      The birth year of the user (not used in this test).
     * @param email     The email of the user to log in.
     * @param company   The company name of the user (not used in this test).
     * @param password  The password of the user to log in.
     */
    @Test(priority = 2, dataProvider = "csvData", dataProviderClass = CSVUtils.class)
    public void loginTest(String firstname, String lastname, String day, String month, String year, String email, String company, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        loginPage.assertSuccessLogin();
    }
}
