package tests.US20;

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
import java.util.ArrayList;
import java.util.List;

public class TC01 extends TestBaseRapor {
    PearlyMarketPages pearlyMarketPages=new PearlyMarketPages();
    Reports_ReviewsPages reportsReviewsPages=new Reports_ReviewsPages();
    Actions action=new Actions(Driver.getDriver());
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
    @Test
    public void test1() throws InterruptedException {
        extentTest=extentReports.createTest("US20, Ürünler Yorum Tablosu",
                "Vendor kullanıcı Store Manager olarak Reviews linki altındaki ürün yorumları tablosunu görebilmeli");

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

        jse.executeScript("arguments[0].click();", reportsReviewsPages.reviewsLink);

        List<String> actualReviewsTableHead=new ArrayList<>();
        for (WebElement each:reportsReviewsPages.reviewsTableThead
             ) {
            actualReviewsTableHead.add(each.getText());

        }

                for (int i = 0; i < reportsReviewsPages.expectedTableHead.size(); i++) {

            Assert.assertTrue(actualReviewsTableHead.contains(reportsReviewsPages.expectedTableHead.get(i)));
            
        }
                extentTest.pass("Vendor kullanıcı Store Manager olarak Reviews linki altındaki tabloyu başarılı bir şekilde görebildi");
    }

}
