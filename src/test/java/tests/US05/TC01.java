package tests.US05;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPages;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC01 extends TestBaseRapor {

    @Test
    public void testcase01() throws InterruptedException {

        extentTest = extentReports.createTest("Urunlere ait basliklari gorebilmeli","Store Manager olarak, Products a gidip   status, stock, price, date den olusan urun listesini gorebilmeli");
        ProductsPages productsPages = new ProductsPages();
        Actions actions = new Actions(Driver.getDriver());

        //  Kullanici "https://pearlymarket.com/" Url'ine gider
        //  Kullanici Vendor hesabi ile giriş yapmak icin Sign In 'e  tiklar
        Driver.getDriver().get("https://pearlymarket.com/");
        productsPages.singIn.click();

        //  Kullanici gecerli  bir email , sifre  girer ve Sing İn Butonuna tiklar
        //  Kullanici ana sayafaya basarili bir sekilde giris yaptigini dogrular
        productsPages.username.sendKeys("kubraesra27@hotmail.com");
        productsPages.password.sendKeys("Esrakubra2!");
        productsPages.signInButton.click();
        String expectedUrl = "https://pearlymarket.com/";
        Assert.assertEquals(expectedUrl, Driver.getDriver().getCurrentUrl());


        //  Kullanici ana sayfada My Account linkine tiklar
        //  Kullanici My Account'a giris yaptigini dogrular
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.waitFor(2);
        productsPages.myAccount.click();
        WebElement actualAccountText = productsPages.myAccountText;
        Assert.assertTrue(actualAccountText.isDisplayed());


        //  Kullanici acilan sayfada Store Manager linkine  tiklar
        //  Kullanici Store Manager'a giris yaptigini dogrular
        ReusableMethods.waitFor(1);
        productsPages.storeManager.click();
        WebElement actualStoreManager = productsPages.storeManagerText;
        Assert.assertTrue(actualStoreManager.isDisplayed());

        //  Kullanici  acilan sayfada Products linkine  tiklar
        //  Kullanici Products 'a giris yaptigini dogrular
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        productsPages.products.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement actualProductsText = productsPages.productsText;
        Assert.assertTrue(actualProductsText.isDisplayed());

        //  Kullanici Prpducts sayfasinda urun listesinin yer aldigi tabloda
        //  status, stok, price ve date baslıklarının oldugunu dogrular
        ReusableMethods.waitFor(1);
        WebElement actualStatus = productsPages.status;
        Assert.assertTrue(actualStatus.isDisplayed());

        WebElement actualStok = productsPages.stok;
        Assert.assertTrue(actualStok.isDisplayed());

        WebElement actualPrice = productsPages.price;
        Assert.assertTrue(actualPrice.isDisplayed());

        WebElement actualDate = productsPages.date;
        Assert.assertTrue(actualDate.isDisplayed());
        extentTest.info("Store Manager olarak Products  menusunden   status, stock, price, date den olusan urun listesine ait basliklarin oldugunu gorur");

        //  Kullanici sayfayi kapatir
        ReusableMethods.waitFor(3);
        Driver.closeDriver();

    }
}
