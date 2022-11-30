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

public class TC02 extends TestBaseRapor {
    PearlyMarketPages pearlyMarketPages=new PearlyMarketPages();
    Reports_ReviewsPages reportsReviewsPages=new Reports_ReviewsPages();
    Actions action=new Actions(Driver.getDriver());
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
    @Test(groups = "gp1")
    public void test1() throws InterruptedException {
        extentTest=extentReports.createTest("US12_Hesabımda Tum Portala Erisebilme",
                "TC_002_Vendor kullanıcı  hesabım sayfasında  indirmeler linkine tıkladığında  indirilenler sayfasına gidebilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("pearlyMarketUrl"));
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(ConfigReader.getProperty("pearlyMarketUrl"), actualUrl);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.visibilityOf(pearlyMarketPages.SignIn));
       // jse.executeScript("arguments[0].click();", pearlyMarketPages.SignIn);
        pearlyMarketPages.SignIn.click();
        pearlyMarketPages.username.sendKeys(ConfigReader.getProperty("validEmail"));
        pearlyMarketPages.password.sendKeys(ConfigReader.getProperty("validPassword"));
        pearlyMarketPages.submitbutton.click();
        Thread.sleep(2000);

        jse.executeScript("arguments[0].click();", pearlyMarketPages.myAccountButton);
        Assert.assertTrue(pearlyMarketPages.myAccountSayfasi.isDisplayed());

        Thread.sleep(2000);

        reportsReviewsPages.downloadsButton.click();

       Assert.assertTrue(reportsReviewsPages.downloadPageControlText.isDisplayed());

        extentTest.pass("Vendor kullanıcı  hesabım sayfasında  indirmeler linkine " +
                "tıkladığında  indirilenler sayfasına gidebildi");

        reportsReviewsPages.signOutButton.click();
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();", reportsReviewsPages.logOutButton);

    }
}
