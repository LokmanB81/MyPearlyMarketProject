package tests.US16;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Customer_RefundPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC05 extends TestBaseRapor {

    Customer_RefundPages customerPage = new Customer_RefundPages();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void testcase03() throws InterruptedException {
        extentTest=extentReports.createTest("Manage customers sayfasinda yeni kisi eklenebilmeli; kullanıcı adi, email, isim, soyisim bilgileri girilebilmeli");

        //1-Vendor url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("pearlyMarketUrl"));

        //2-Vendor giris icin sign in butonuna tiklar
        customerPage.signIn.click();

        //3-Vendor sisteme kayıtlı email girer
        customerPage.usarnameBar.sendKeys(ConfigReader.getProperty("validEmail"));


        //4-Vendor sisteme kayıtlı password girer
        customerPage.passwordBar.sendKeys(ConfigReader.getProperty("validPassword"));

        //5-Vendor login butonuna tiklar
        customerPage.login.click();

        Thread.sleep(3000);

        //6-Vendor store manager'a tiklar
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", customerPage.myAccount);
        Thread.sleep(2000);
        customerPage.myAccount.click();
        customerPage.storeManager.click();

        //7-Vendor customers linkine tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();", customerPage.customer);


        //8-Manage Customers sayfasinda add new tuşuna basar, kullanıcı adı, email, isim,
        // soyisim bilgilerinin girebildigini kontrol edilir
        jse.executeScript("arguments[0].click();", customerPage.addNew);
        customerPage.addCustomerUserName.sendKeys(Faker.instance().name().username());
        customerPage.addCustomerUserEmail.sendKeys(Faker.instance().internet().emailAddress());
        customerPage.addCustomerFirstName.sendKeys(Faker.instance().name().firstName());
        customerPage.addCustomerLastName.sendKeys(Faker.instance().name().lastName());

        jse.executeScript("arguments[0].scrollIntoView(true);", customerPage.billingZipCode);

        jse.executeScript("arguments[0].click();", customerPage.customerPageSubmitButton);

        ReusableMethods.waitForVisibility(customerPage.customerSuccessfullySavedText, 5);

        Assert.assertTrue(customerPage.editCustomerText.isDisplayed());

        extentTest.pass("Manage Customers sayfasinda add new tuşuna basar, kullanıcı adı, email, isim, soyisim bilgileri girilebildigi doğrulandi");

        Driver.closeDriver();


    }
}
