package tests.US12;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPages;
import pages.Reports_ReviewsPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC01 extends TestBaseRapor {
    PearlyMarketPages pearlyMarketPages=new PearlyMarketPages();
    Reports_ReviewsPages reportsReviewsPages=new Reports_ReviewsPages();
    Actions action=new Actions(Driver.getDriver());
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
    @Test(groups = "gp1")
    public void test1() throws InterruptedException {
        extentTest=extentReports.createTest("US12_Hesabımda Tum Portala Erisebilme",
                "TC_001_Vendor kullanıcı  hesabım sayfasında  siparişler linkine tıkladığında sipariş edilen ürünleri görebilmeli");

        Driver.getDriver().get(ConfigReader.getProperty("pearlyMarketUrl"));
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(ConfigReader.getProperty("pearlyMarketUrl"), actualUrl);

        pearlyMarketPages.SignIn.click();
        pearlyMarketPages.username.sendKeys(ConfigReader.getProperty("validEmail"));
        pearlyMarketPages.password.sendKeys(ConfigReader.getProperty("validPassword"));
        pearlyMarketPages.submitbutton.click();
        Thread.sleep(2000);

        jse.executeScript("arguments[0].click();", pearlyMarketPages.myAccountButton);
        Assert.assertTrue(pearlyMarketPages.myAccountSayfasi.isDisplayed());

        Thread.sleep(2000);

        reportsReviewsPages.orderButton.click();

        Assert.assertTrue(reportsReviewsPages.ordersTable.isDisplayed());

        extentTest.pass("Vendor kullanıcı  hesabım sayfasında  siparişler linkine tıkladığında sipariş edilen ürünleri görebildi");

        reportsReviewsPages.signOutButton.click();
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();", reportsReviewsPages.logOutButton);
        Thread.sleep(2000);
       // reportsReviewsPages.logOutButton.click();
    }
}
