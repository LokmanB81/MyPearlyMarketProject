package tests.US13;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CouponsPages;
import pages.PearlyMarketPages;
import utilities.Driver;

public class TC03 {
    PearlyMarketPages pearlyMarketPages = new PearlyMarketPages();
    CouponsPages couponsPages = new CouponsPages();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test03(){

    }

}
