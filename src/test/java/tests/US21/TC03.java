package tests.US21;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPages;
import pages.Reports_ReviewsPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC03 extends TestBaseRapor {
    PearlyMarketPages pearlyMarketPages=new PearlyMarketPages();
    Reports_ReviewsPages reportsReviewsPages=new Reports_ReviewsPages();
    JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
    @Test
    public void test1() throws InterruptedException {

        extentTest=extentReports.createTest("US21 Ürün satış raporlarının incelenmesi",
                "TC_003_Vendor kullanıcı Store manager olarak  satis raporlarını 'içinde bulunulan ay' tablosu olarak görüntüleyebilmeli");
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

        reportsReviewsPages.storeManagerLink.click();

        jse.executeScript("arguments[0].click();", reportsReviewsPages.reportsLink);

        Assert.assertTrue(reportsReviewsPages.reportsPageControlText.isDisplayed());

        reportsReviewsPages.reportsThisMonthButton.click();

        Assert.assertTrue(reportsReviewsPages.reportsPageTableHeadingText.isDisplayed());
        Assert.assertTrue(reportsReviewsPages.reportsPageTable.isDisplayed());


        extentTest.pass("Vendor kullanıcı Store manager olarak  satis raporlarını 'içinde bulunulan ay' tablosu olarak görüntüleyebildi");

    }
}
