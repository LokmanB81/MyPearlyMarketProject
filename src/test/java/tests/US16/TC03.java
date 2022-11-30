package tests.US16;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Customer_RefundPages;
import pages.PearlyMarketPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TC03 extends TestBaseRapor {

    PearlyMarketPages pearlyMarketPages=new PearlyMarketPages();
    Customer_RefundPages customerPage=new Customer_RefundPages();
    Actions actions=new Actions(Driver.getDriver());

    @Test
    public void userStory16testcase03() throws InterruptedException {

        extentTest=extentReports.createTest("Manage customers sayfasinda kayitli kisilerin tum bilgileri pdf, excel ve csv olarak indirilebilmeli");

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


        jse.executeScript("arguments[0].scrollIntoView(true);", customerPage.manageCustomerText);

        //Manage Customers sayfasinda kayitli kisilerin tüm bilgilerinin
        // excel formatinda indirilmesi dogrulanir
        String homePath= System.getProperty("user.home");
        String excelFilePath=homePath+"\\Downloads\\Store Manager - Pearly Market.xlsx";

        jse.executeScript("arguments[0].click();", customerPage.customerDataExcelDownload);

        Thread.sleep(2000);

        Assert.assertTrue(Files.exists(Paths.get(excelFilePath)));

        extentTest.pass("Manage customers sayfasinda kayitli kisilerin tum bilgileri excel formatında indirilebildigi dogrulandi");

        Driver.closeDriver();

    }

}
