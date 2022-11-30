package tests.US05;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPages;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC06 extends TestBaseRapor {

    @Test
    public void testCase06() throws InterruptedException {

        extentTest = extentReports.createTest("(short description, Description) seceneklerine  aciklama ekleyebilmeli ","Store Manager olarak  Kisa tanımlama ve geniş tanımlama (short description, Description) seceneklerine  aciklama eklendıgini gormeli");
        ProductsPages productsPages = new ProductsPages();
        Actions actions = new Actions(Driver.getDriver());

        //  Kullanici "https://pearlymarket.com/" Url'ine gider
        //  Kullanici Vendor hesabi ile giriş yapmak icin Sign In 'e  tiklar
        Driver.getDriver().get("https://pearlymarket.com/");
        productsPages.singIn.click();

        //  Kullanici gecerli  bir email , sifre  girer ve Sing İn Butonuna tiklar
        productsPages.username.sendKeys("kubraesra27@hotmail.com");
        productsPages.password.sendKeys("Esrakubra2!");
        productsPages.signInButton.click();

        //  Kullanici ana sayfada My Account linkine tiklar
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.waitFor(2);
        productsPages.myAccount.click();

        //  Kullanici acilan sayfada Store Manager linkine  tiklar
        ReusableMethods.waitFor(1);
        productsPages.storeManager.click();

        //  Kullanici  acilan sayfada Products linkine  tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        productsPages.products.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //  Kullanici Products ekranından Yeni urun ekle (Add new) butonuna tiklar
        ReusableMethods.waitFor(1);
        productsPages.addNew.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //   Kullanici kisa tanımlama (short description)secenegini  gorur
        Assert.assertTrue(productsPages.shortDescription.isDisplayed());
        Assert.assertTrue(productsPages.shortDescription.getText().contains("Short Description"));


        //   Kullanici short description secenegine  kisa aciklama girer
        Driver.getDriver().switchTo().frame(productsPages.iframe.get(0));
        productsPages.shortDescriptionBox.get(0).click();
        productsPages.shortDescriptionBox.get(0).sendKeys("Takim birlikteligi basarinin sirridir.");
        ReusableMethods.waitFor(3);
        Driver.getDriver().switchTo().parentFrame();

        //   Kullanici genis tanimlama (Description) secenegini gorur
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(productsPages.description.isDisplayed());
        Assert.assertTrue(productsPages.description.getText().contains("Description"));

        //   Kullanici  Description secenegine uzun aciklama girer
        Driver.getDriver().switchTo().frame(productsPages.iframe.get(1));
        productsPages.shortDescriptionBox.get(0).click();
        productsPages.shortDescriptionBox.get(0).sendKeys("Proje12 Ekibi ve Team8 ile biz bu basariyi yakaladik. Herşey Cok Guzel olacak :))");
        extentTest.info("Store Manager olarak  Kisa tanımlama ve geniş tanımlama (short description, Description) seceneklerine aciklama eklendigini gorur");

        //   Kullanici sayfayi kapatir
        ReusableMethods.waitFor(3);
        Driver.closeDriver();

    }
}
