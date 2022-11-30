package tests.US01;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPages;
import pages.ProductsPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class TC01 extends TestBaseRapor {
    ProductsPages productsPages;
    PearlyMarketPages pearlyMarketpages ;
    Actions actions ;
    JavascriptExecutor jse ;

    @Test(groups="smoke")
    public void US02_TC01_validSignIn() throws InterruptedException {
        productsPages=new ProductsPages();
        pearlyMarketpages=new PearlyMarketPages();
        actions=new Actions(Driver.getDriver());
        jse=(JavascriptExecutor) Driver.getDriver();

        extentTest=extentReports.createTest("US02, Vendor olarak başarılı sign in",
                "TC01_Vendor kullanıcı geçerli username ve şifre ile sign in olup my account sayfasına ulaşabilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("pearlyMarketUrl"));
        jse.executeScript("arguments[0].click();", pearlyMarketpages.SignIn);
       // pearlyMarketpages.SignIn.click();
        Thread.sleep(1000);
        pearlyMarketpages.username.sendKeys(ConfigReader.getProperty("validEmail"));
        Thread.sleep(1000);
        pearlyMarketpages.password.sendKeys(ConfigReader.getProperty("validPassword"));
        Thread.sleep(1000);
        pearlyMarketpages.submitbutton.click();
            Thread.sleep(1000);
         actions.sendKeys(Keys.END).perform();
        //jse.executeScript("arguments[0].scrollIntoView(true);",
            //    pearlyMarketpages.myAccountButton);
        Thread.sleep(500);
        jse.executeScript("arguments[0].click();", pearlyMarketpages.myAccountButton);

       // Thread.sleep();

        Assert.assertTrue(pearlyMarketpages.myAccountSayfasi.isDisplayed());

        extentTest.pass("Vendor kullanıcı geçerli username ve şifre ile sign in olup my account sayfasına ulaşabildi");
        Driver.closeDriver();


    }
}
