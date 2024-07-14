package pagestests;

import org.testng.annotations.Test;
import pages.CheckoutProcess;
import setup.BaseTest;
import utils.DataInjectionIntern;

public class CheckoutProcessTest extends BaseTest {


    @Test(priority = 4, dataProvider = "userData", dataProviderClass = DataInjectionIntern.class)
    public void checkoutTest(String cityName, String addressOne, String addressTwo, String zipCode, String phone, String fax) {
        new CheckoutProcess(driver).checkoutItem(cityName, addressOne, addressTwo, zipCode, phone, fax);

    }
}
