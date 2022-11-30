package tests.US13;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CouponsPages;
import pages.PearlyMarketPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02 extends TestBaseRapor {
    PearlyMarketPages pearlyMarketPages = new PearlyMarketPages();
    CouponsPages couponsPages = new CouponsPages();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test02() throws InterruptedException {

        extentTest=extentReports.createTest("Kupon tarihine geçmiş bir tarih girilememeli","Kullanıcı \"Coupon expiry date\" kutucuğuna geçmiş bir tarih girdiğinde kayıt yapamamalı");

        // Kullanıcı url sayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyMarketUrl"));
        // Kullanıcı açılan sayfadan sign in butonuna tıklar
        pearlyMarketPages.SignIn.click();
        // Kullanıcı vendor olarak "Username or email adress" kutusuna gecerli mail adresi girer
        pearlyMarketPages.username.sendKeys(ConfigReader.getProperty("validEmail"));
        // "Password" kutusuna geçerli şifreyi girer
        pearlyMarketPages.password.sendKeys(ConfigReader.getProperty("validPassword"));
        // Kullanıcı sign in butonuna tıklar
        couponsPages.signinButton.click();
        Thread.sleep(2000);
        // Kullanici "My Account" butonuna tıklar
        jse.executeScript("arguments[0].scrollIntoView(true);",pearlyMarketPages.myAccountButton);
        jse.executeScript("arguments[0].click();", pearlyMarketPages.myAccountButton);

        Thread.sleep(2000);
        // Kullanıcı "My Account" sayfasında olduğunu doğrular
        Assert.assertTrue(pearlyMarketPages.myAccountSayfasi.isDisplayed());
        // Kullanıcı "Store Manager" butonuna tıklar
        couponsPages.storeManager.click();
        // Kullanıcı "Coupons" butonuna tıklar
        jse.executeScript("arguments[0].click();",couponsPages.couponsButton);
        // Kullanıcı "Add New" butonunun görüntülendiğini doğrular
        Assert.assertTrue(couponsPages.addNewButton.isDisplayed());
        // Kullanıcı Add New butonuna tıklar
        couponsPages.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        // Kullanıcı "Code" kutusuna kupon kodu değerini girer
        couponsPages.codeBox.sendKeys(Faker.instance().book().title());
        // Kullanıcı "Discount Type" menüsünden "Fixed Product" seçeneğini seçer
        WebElement ddmList = couponsPages.discountType;
        Select select = new Select(ddmList);
        select.selectByIndex(1);
        // Kullanıcı "Coupon amount" kutucuğuna rakamsal bir değer girer
        couponsPages.couponAmount.sendKeys(Faker.instance().number().digit());
        // Kullanıcı "Coupon expiry date" kutucuğuna geçmiş bir tarih bilgisi girer
        couponsPages.expiryDateBox.sendKeys("01012022");
        // Kullanici "Submit" butonuna tıklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        jse.executeScript("arguments[0].click();",couponsPages.submitButton);
        // Kullanıcı kuponu kaydedemediğini doğrular
        ReusableMethods.waitForVisibility(couponsPages.popUpMessageHappy,5);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(couponsPages.popUpMessageHappy.isDisplayed());

        extentTest.info("Kullanıcı \"Coupon expiry date\" kutucuğuna geçmiş bir tarih girdiğinde kayıt yapabildi");

        // Kullanıcı sayfayı kapatır
        Driver.closeDriver();


    }
}
