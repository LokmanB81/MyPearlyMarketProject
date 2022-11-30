package tests.crosstests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

import java.util.List;

public class US01_TC01 extends TestBaseCross {
    PearlyMarketPages pearlyMarketpages =new PearlyMarketPages();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void testsignin() throws InterruptedException {


        Driver.getDriver().get(ConfigReader.getProperty("pearlyMarketUrl"));
        pearlyMarketpages.SignIn.click();
        Thread.sleep(2000);
        pearlyMarketpages.username.sendKeys(ConfigReader.getProperty("validEmail"));
        Thread.sleep(2000);
        pearlyMarketpages.password.sendKeys(ConfigReader.getProperty("validPassword"));
        Thread.sleep(2000);
        pearlyMarketpages.submitbutton.click();
        ReusableMethods.waitFor(2);
        // actions.sendKeys(Keys.END).perform();
        jse.executeScript("arguments[0].scrollIntoView(true);",
                pearlyMarketpages.myAccountButton);
        jse.executeScript("arguments[0].click();", pearlyMarketpages.myAccountButton);

        Thread.sleep(2000);

        Assert.assertTrue(pearlyMarketpages.myAccountSayfasi.isDisplayed());

        List<WebElement> orders=pearlyMarketpages.orders;
        for (WebElement w : orders) {
            Assert.assertTrue(w.isDisplayed());
        }

        List<WebElement> storemanager=pearlyMarketpages.storemanager;
        for (int i = 5; i <25 ; i++) {
            Assert.assertTrue(storemanager.get(i).isDisplayed());
            ReusableMethods.waitFor(2);
        }


    }
}
