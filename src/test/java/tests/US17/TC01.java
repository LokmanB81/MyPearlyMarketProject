package tests.US17;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Customer_RefundPages;
import pages.PearlyMarketPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC01 extends TestBaseRapor {

    PearlyMarketPages pearlyMarketPages=new PearlyMarketPages();
    Customer_RefundPages customerPage=new Customer_RefundPages();
    Actions actions=new Actions(Driver.getDriver());

    @Test
    public void userStory17TestCase01() throws InterruptedException {

        extentTest=extentReports.createTest("Manage customers sayfasinda add new butona basildiginda \n" +
                "billing altinda  isim, soy isim, şirket ismi, tel, adres1 ve adres iki (optional), ülke, sehir, posta kodu eklenebilmeli");

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


        //8-Manage Customers sayfasinda add new tuşuna basar,billing altinda  isim, soy isim, şirket ismi, tel,
        // adres1 ve adres iki (optional), ülke, sehir, posta kodu eklenebildigini kontrol eder
        jse.executeScript("arguments[0].click();", customerPage.addNew);
        customerPage.addCustomerUserName.sendKeys(Faker.instance().name().username());
        customerPage.addCustomerUserEmail.sendKeys(Faker.instance().internet().emailAddress());
        customerPage.addCustomerFirstName.sendKeys(Faker.instance().name().firstName());
        customerPage.addCustomerLastName.sendKeys(Faker.instance().name().lastName());

        customerPage.billingFirstName.sendKeys(Faker.instance().name().firstName());
        customerPage.billingLastName.sendKeys(Faker.instance().name().lastName());
        customerPage.billingCompanyName.sendKeys(Faker.instance().company().name());
        customerPage.billingPhone.sendKeys(Faker.instance().phoneNumber().cellPhone());
        customerPage.billingAdress1.sendKeys(Faker.instance().address().fullAddress());
        customerPage.billingAdress2.sendKeys(Faker.instance().address().secondaryAddress());

        Select select = new Select(customerPage.billingSelectCountry);
        select.selectByVisibleText("Netherlands");

        customerPage.billingCity.sendKeys(Faker.instance().address().city());

        customerPage.billingZipCode.sendKeys(Faker.instance().address().zipCode());

        Thread.sleep(2000);

        jse.executeScript("arguments[0].scrollIntoView(true);", customerPage.billingZipCode);

        jse.executeScript("arguments[0].click();", customerPage.customerPageSubmitButton);

        Assert.assertTrue(customerPage.editCustomerText.isDisplayed());

        extentTest.pass("Manage customers sayfasinda add new butona basildiginda \n" +
                "billing altinda  isim, soy isim, şirket ismi, tel, adres1 ve adres iki (optional), ülke, sehir, posta kodu eklenebildigi doğrulandi");

        Driver.closeDriver();

    }
}
