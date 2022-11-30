package tests.US21;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPages;
import pages.Reports_ReviewsPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC05 extends TestBaseRapor {
    PearlyMarketPages pearlyMarketPages=new PearlyMarketPages();
    Reports_ReviewsPages reportsReviewsPages=new Reports_ReviewsPages();
    JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
    Actions action=new Actions(Driver.getDriver());
    @Test
    public void test1() throws InterruptedException {

        extentTest=extentReports.createTest("US21 Ürün satış raporlarının incelenmesi",
                "TC_005_Vendor kullanıcı Store manager olarak satis raporlarını " +
                        "'spesifik bir tarih aralığı'  girerek görüntüleyebilmeli");
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

        reportsReviewsPages.reportsDateChooseBox.click();
        action.sendKeys(Keys.PAGE_DOWN).perform();

        action.click(reportsReviewsPages.calendarDays.get(0)).
                click(reportsReviewsPages.calendarDays.get(5)).perform();

        Assert.assertTrue(reportsReviewsPages.reportsPageTableHeadingText.isDisplayed());
        Assert.assertTrue(reportsReviewsPages.reportsPageTable.isDisplayed());


        extentTest.pass("Vendor kullanıcı Store manager olarak satis raporlarını " +
                "'spesifik bir tarih aralığı' girerek görüntüleyebildi");

    }
}
