package tests.US12;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPages;
import pages.Reports_ReviewsPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC04 extends TestBaseRapor {
    PearlyMarketPages pearlyMarketPages=new PearlyMarketPages();
    Reports_ReviewsPages reportsReviewsPages=new Reports_ReviewsPages();
    Actions action=new Actions(Driver.getDriver());
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
    @Test
    public void test1() throws InterruptedException {
        extentTest=extentReports.createTest("US12_Hesabımda Tum Portala Erisebilme",
                "TC_004_Vendor kullanıcı  hesabım sayfasında hesap detaylarını tıkladığında hesabıyla ilgili hesap bilgilerini," +
                        " email adresini görebilmeli ve bunları güncelleyebilmeli");
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
        jse.executeScript("arguments[0].click();",reportsReviewsPages.accountDetailsButton);

        for (int i = 0; i < 3; i++) {
            Assert.assertTrue(reportsReviewsPages.accountDetailsNames.get(i).isDisplayed());
        }

        Assert.assertTrue(reportsReviewsPages.accountDetailEmail.isDisplayed());
        extentTest.pass("Vendor kullanıcı  hesabım sayfasında hesap detaylarını tıkladığında hesabıyla ilgili hesap bilgilerini, " +
                "email adresini görebildi");
        
        
        
        for (int i = 0; i < 3; i++) {
            Assert.assertTrue(reportsReviewsPages.accountDetailsNames.get(i).isEnabled());
        }

        Assert.assertTrue(reportsReviewsPages.accountDetailEmail.isEnabled());

        for (int i = 2; i <5 ; i++) {
            Assert.assertTrue(reportsReviewsPages.accountDetailpassword.get(i).isEnabled());
        }

        jse.executeScript("arguments[0].click();", reportsReviewsPages.saveChangesButton);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(reportsReviewsPages.succesfullText));
        Assert.assertTrue(reportsReviewsPages.succesfullText.isDisplayed());
        extentTest.pass("Vendor kullanıcı  hesabım sayfasında hesabıyla ilgili bilgilerini güncelleyebildi");

    }


}
