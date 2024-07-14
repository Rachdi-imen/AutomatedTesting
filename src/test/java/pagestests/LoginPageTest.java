package pagestests;

import org.testng.annotations.Test;
import pages.LoginPage;
import setup.BaseTest;
import utils.CSVUtils;
import utils.DataInjectionIntern;

public class LoginPageTest extends BaseTest {

    //String email = "imenTest@gmail.com";
    //String pwd = "test123";

    @Test(priority = 2,dataProvider = "csvData", dataProviderClass = CSVUtils.class)
    public void loginTest(String firstname, String lastname, String day, String month, String year, String email, String company, String password) {

        new LoginPage(driver).login(email, password);
    }
}
