package tests.US12;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

public class TC03 extends TestBaseRapor {
    PearlyMarketPages pearlyMarketPages=new PearlyMarketPages();
    Reports_ReviewsPages reportsReviewsPages=new Reports_ReviewsPages();
    Actions action=new Actions(Driver.getDriver());
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
    @Test
    public void test1() throws InterruptedException {
        extentTest=extentReports.createTest("US12_Hesabımda Tum Portala Erisebilme",
                "TC_003_Vendor kullanıcı  hesabım sayfasında adresler linkine tıkladığında fatura ve gönderim adreslerini görebilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("pearlyMarketUrl"));
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(ConfigReader.getProperty("pearlyMarketUrl"), actualUrl);
        Thread.sleep(2000);
        pearlyMarketPages.SignIn.click();
        pearlyMarketPages.username.sendKeys(ConfigReader.getProperty("validEmail"));
        pearlyMarketPages.password.sendKeys(ConfigReader.getProperty("validPassword"));
        pearlyMarketPages.submitbutton.click();
        Thread.sleep(2000);

        jse.executeScript("arguments[0].click();", pearlyMarketPages.myAccountButton);
        Assert.assertTrue(pearlyMarketPages.myAccountSayfasi.isDisplayed());

        Thread.sleep(2000);

        reportsReviewsPages.addressesButton.click();

        for (WebElement each:reportsReviewsPages.adresTableDatas
             ) {
            Assert.assertTrue(each.isDisplayed());
        }


        extentTest.pass("Vendor kullanıcı  hesabım sayfasında adresler linkine tıkladığında fatura ve gönderim adreslerini görebildi");

    }
}
