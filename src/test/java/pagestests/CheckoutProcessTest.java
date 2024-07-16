package pagestests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutProcess;
import setup.BaseTest;
import utils.DataInjectionIntern;

public class CheckoutProcessTest extends BaseTest {

    /**
     * Tests the checkout process by verifying the order confirmation message after completing the checkout.
     */
    @Test(priority = 4, dataProvider = "userData", dataProviderClass = DataInjectionIntern.class)
    public void checkoutTest(String cityName, String addressOne, String addressTwo, String zipCode, String phone, String fax) {
        CheckoutProcess checkoutProcess = new CheckoutProcess(driver);
        checkoutProcess.checkoutItem(cityName, addressOne, addressTwo, zipCode, phone, fax);

        // Assert success order confirmation
        String assertSuccessOrder = checkoutProcess.assertOrderConfirmation();
        Assert.assertEquals(assertSuccessOrder, "Your order has been successfully processed!",
                "Order confirmation message does not match the expected value.");
    }
}
