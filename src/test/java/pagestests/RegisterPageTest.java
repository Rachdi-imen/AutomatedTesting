package pagestests;

import org.testng.Assert;
import org.testng.annotations.*;
import setup.BaseTest;
import pages.RegisterPage;
import utils.CSVUtils;

public class RegisterPageTest extends BaseTest {

    @Test(priority = 1, dataProvider = "csvData", dataProviderClass = CSVUtils.class)
    public void registerPageTest(String firstname, String lastname, String day, String month, String year, String email, String company, String password) {

        new RegisterPage(driver).register(firstname, lastname, day, month, year, email, company, password);



    }
}
