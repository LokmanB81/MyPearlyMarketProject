package tests.US07;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductsPages;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC01 extends TestBaseRapor {

    @Test
    public void testCase01() throws InterruptedException {

        extentTest = extentReports.createTest(" Store Manager olarak Product brands sekmesinden sekmesine brands belirleyebilmeli","Store Manager  olarak Product brands sekmesinden\n" +
                "Elegant Auto Group, Green Grass, Node Js, NS8 ,RED,Skysuite Tech ,  Skysuite Tech,  Sterling brands'lerini  gormeli ve secmeli ");
        ProductsPages productsPages=new ProductsPages();
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

        //   Kullanici Product brands sekmesinin oldugunu dogrular
        Assert.assertTrue(productsPages.pruductBrands.isDisplayed());
        Assert.assertTrue(productsPages.pruductBrands.getText().contains("Product brands"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //   Kullanici Product brands sekmesinden  Elegant Auto Group seceneginin oldugunu dogrular
        //   Kullanici Product brands sekmesinden urun brand'i olarak Elegant Auto Group secenegini secer
        ReusableMethods.waitFor(2);
        Assert.assertTrue(productsPages.elegantAutoGroupText.isDisplayed());
        Assert.assertTrue(productsPages.elegantAutoGroupText.getText().contains("Elegant Auto Group"));
        productsPages.elegantAutoGroupCheckBox.click();


        //   Kullanici Product brands sekmesinden  Green Grass seceneginin oldugunu dogrular
        //   Kullanici Product brands sekmesinden urun brand'i olarak Green Grass secenegini secer
        ReusableMethods.waitFor(1);
        Assert.assertTrue(productsPages.greenGrassText.isDisplayed());
        Assert.assertTrue(productsPages.greenGrassText.getText().contains("Green Grass"));
        productsPages.greenGrassCheckBox.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //   Kullanici Product brands sekmesinden Node Js seceneginin oldugunu dogrular
        //   Kullanici Product sekmesinden urun katagorisi olarak Node Js  secenegini secer
        ReusableMethods.waitFor(1);
        Assert.assertTrue(productsPages.nodeJsText.isDisplayed());
        Assert.assertTrue(productsPages.nodeJsText.getText().contains("Node Js"));
        productsPages.nodeJsCheckBox.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //   Kullanici Product brands sekmesinden NS8 seceneginin oldugunu dogrular
        //   Kullanici Product brands sekmesinden urun brand'i olarak NS8 secenegini secer
        ReusableMethods.waitFor(1);
        Assert.assertTrue(productsPages.nS8Text.isDisplayed());
        Assert.assertTrue(productsPages.nS8Text.getText().contains("NS8"));
        productsPages.nS8CheckBox.click();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //   Kullanici Product brands sekmesinden RED seceneginin oldugunu dogrular
        //   Kullanici Product brands sekmesinden urun brand'i olarak RED secenegini secer
        ReusableMethods.waitFor(1);
        Assert.assertTrue(productsPages.redText.isDisplayed());
        Assert.assertTrue(productsPages.redText.getText().contains("RED"));
        productsPages.redCheckBox.click();

        //   Kullanici Product brands sekmesinden Skysuite Tech seceneginin oldugunu dogrular
        //   Kullanici Product brands sekmesinden urun brand'i olarak Skysuite Tech secenegini secer
        ReusableMethods.waitFor(1);
        Assert.assertTrue(productsPages.skysuiteTechText.isDisplayed());
        Assert.assertTrue(productsPages.skysuiteTechText.getText().contains("Skysuite Tech"));
        productsPages.skysuiteTechCheckBox.click();

        //   Kullanici Product brands sekmesinden Sterling seceneginin oldugunu dogrular
        //   Kullanici Product brands sekmesinden urun brand'i Sterling secenegini secer
        ReusableMethods.waitFor(1);
        Assert.assertTrue(productsPages.sterlingText.isDisplayed());
        Assert.assertTrue(productsPages.sterlingText.getText().contains("Sterling"));
        productsPages.sterlingCheckBox.click();
        extentTest.info("Store Manager  olarak Product brands sekmesinden\n" +
                "Elegant Auto Group, Green Grass, Node Js, NS8 ,RED,Skysuite Tech ,  Skysuite Tech,  Sterling brands'leri  gorur ve secer ");

        //   Kullanici sayfayi kapatir
        ReusableMethods.waitFor(3);
        Driver.closeDriver();





    }
}
