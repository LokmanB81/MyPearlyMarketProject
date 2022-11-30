package tests.US16;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Customer_RefundPages;
import pages.PearlyMarketPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC01 extends TestBaseRapor {

    PearlyMarketPages pearlyMarketPages=new PearlyMarketPages();
    Customer_RefundPages customerPage=new Customer_RefundPages();

    Actions actions=new Actions(Driver.getDriver());

    SoftAssert softAssert=new SoftAssert();

    @Test
    public void userStory16testcase01() throws InterruptedException {

        extentTest=extentReports.createTest("Manage customers; kayitli kisilerin isim/ kullanıcı adi/ emaili, adresi, harcama miktarı, son siparişleri görülmeli");
       //Vendor url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyMarketUrl"));

       //Vendor giris icin sign in butonuna tiklar
        pearlyMarketPages.SignIn.click();

       //Vendor sisteme kayıtlı emailni girer
        pearlyMarketPages.username.sendKeys(ConfigReader.getProperty("validEmail"));

       //Vendor sisteme kayıtlı password girer
        pearlyMarketPages.password.sendKeys(ConfigReader.getProperty("validPassword"));

       //Vendor login butonuna tiklar
        pearlyMarketPages.submitbutton.click();
        Thread.sleep(3000);

       //Vendor store manager'a tiklar
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", customerPage.myAccount);
        Thread.sleep(2000);
        customerPage.myAccount.click();
        customerPage.storeManager.click();

       //Vendor customers linkine tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();", customerPage.customer);

       //Manage Customers sayfasinda kayitli kisilerin name, usarname, email, location,
        // orders, money spent ve last order bilgilerin görüldügü doğrulanir;
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        for (WebElement w:customerPage.customerTableNameColumn) {
            softAssert.assertTrue(w.isDisplayed());
        }
        for (WebElement w:customerPage.customerTableUserNameColumn) {
            softAssert.assertTrue(w.isDisplayed());
        }
        for (WebElement w:customerPage.customerTableEmailColumn) {
            softAssert.assertTrue(w.isDisplayed());
        }
        for (WebElement w:customerPage.customerTableLocationColumn) {
            softAssert.assertTrue(w.isDisplayed());
        }
        for (WebElement w:customerPage.customerTableOrdersColumn) {
            softAssert.assertTrue(w.isDisplayed());
        }
        for (WebElement w:customerPage.customerTableMoneySpentColumn) {
            softAssert.assertTrue(w.isDisplayed());
        }
        for (WebElement w:customerPage.customerTableLastOrderColumn) {
            softAssert.assertTrue(w.isDisplayed());
        }
        softAssert.assertAll();

        extentTest.pass("Manage customers sayfasinda kayitli kisilerin isim/ kullanıcı adi/ emaili, adresi, harcama miktarı, son siparişleri görüldüğü doğrulandı");

        Driver.closeDriver();

    }
}
