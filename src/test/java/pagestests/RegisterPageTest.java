package pagestests;

import org.testng.annotations.Test;
import setup.BaseTest;
import pages.RegisterPage;
import utils.CSVUtils;

public class RegisterPageTest extends BaseTest {

    /**
     * Tests the registration functionality using data from a CSV file.
     *
     * @param firstname The first name of the user.
     * @param lastname  The last name of the user.
     * @param day       The day of birth of the user.
     * @param month     The month of birth of the user.
     * @param year      The year of birth of the user.
     * @param email     The email of the user.
     * @param company   The company name of the user.
     * @param password  The password for the user account.
     */
    @Test(priority = 1, dataProvider = "csvData", dataProviderClass = CSVUtils.class)
    public void registerPageTest(String firstname, String lastname, String day, String month, String year, String email, String company, String password) {
        RegisterPage registerPage = new RegisterPage(driver);

        // Perform registration
        registerPage.register(firstname, lastname, day, month, year, email, company, password);
        // Log out after registration
        registerPage.logOut();
    }
}
