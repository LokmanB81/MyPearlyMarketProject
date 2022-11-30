package tests.US06;

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
    public void testcase01() throws InterruptedException {

        extentTest = extentReports.createTest(" Store Manager olarak Catagori sekmesine katagori belirleyebilmeli","Store Manager olarak Urunler katagorisinden Besin takviyeleri ,Cok satanlar, Elektrik & Elektronik,Home&Life ,Discounted,  Books & Music & Film , Cosmetics&Personal,Fashion&Clothing, Toys & Games,New Arrivals  katagorilerini   gormeli  ve secmeli");
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

        //  Kullanici Categories sekmesinin oldugunu dogrular
        Assert.assertTrue(productsPages.categories.isDisplayed());
        Assert.assertTrue(productsPages.categories.getText().contains("Categories*"));

        //  Kullanici Catagries sekmesinden urun katagorisi olarak Besin takviyeleri seceneginin oldugunu dogrular
        //  Kullanici Catagries sekmesinden urun katagorisi olarak Besin takviyeleri secenegini secer
        ReusableMethods.waitFor(1);
        Assert.assertTrue(productsPages.besinTakviyeleriText.isDisplayed());
        Assert.assertTrue(productsPages.besinTakviyeleriText.getText().contains("Besin takviyeleri"));
        productsPages.besinTakviyeleriCheckBox.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //  Kullanici Catagries sekmesinden urun katagorisi olarak Cok satanlar seceneginin oldugunu dogrular
        //  Kullanici Catagries sekmesinden urun katagorisi olarak Cok satanlar secenegini secer
        ReusableMethods.waitFor(1);
        Assert.assertTrue(productsPages.cokSatanlarText.isDisplayed());
        Assert.assertTrue(productsPages.cokSatanlarText.getText().contains("Cok satanlar"));
        productsPages.cokSatanlarCheckBox.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //  Kullanici Catagries sekmesinden urun katagorisi olarak Elektrik & Elektronik  seceneginin oldugunu dogrular
        //  Kullanici Catagries sekmesinden urun katagorisi olarak Elektrik & Elektronik  secenegini secer
        ReusableMethods.waitFor(1);
        Assert.assertTrue(productsPages.elektrikElektroniktext.isDisplayed());
        Assert.assertTrue(productsPages.elektrikElektroniktext.getText().contains("Elektrik & Elektronik"));
        productsPages.elektrikElektronikCheckBox.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        //  Kullanici Catagries sekmesinden urun katagorisi olarak Home&Life seceneginin oldugunu dogrular
        //  Kullanici Catagries sekmesinden urun katagorisi olarak Home&Life  secenegini secer
        ReusableMethods.waitFor(1);
        Assert.assertTrue(productsPages.homeLifetext.isDisplayed());
        Assert.assertTrue(productsPages.homeLifetext.getText().contains("Home&Life"));
        productsPages.homeLifeCheckBox.click();
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).perform();


        //  Kullanici Catagries sekmesinden urun katagorisi olarak Discounted seceneginin oldugunu dogrular
        //  Kullanici Catagries sekmesinden urun katagorisi olarak Discounted secenegini secer
        ReusableMethods.waitFor(1);
        Assert.assertTrue(productsPages.discountedtext.isDisplayed());
        Assert.assertTrue(productsPages.discountedtext.getText().contains("Discounted"));
        productsPages.discountedCheckBox.click();
        actions.sendKeys(Keys.PAGE_UP).perform();

        //  Kullanici Catagries sekmesinden urun katagorisi olarak Books & Music & Film seceneginin oldugunu dogrular
        //  Kullanici Catagries sekmesinden urun katagorisi olarak Books & Music & Film secenegini secer
        ReusableMethods.waitFor(1);
        Assert.assertTrue(productsPages.booksMusicFilmtext.isDisplayed());
        Assert.assertTrue(productsPages.booksMusicFilmtext.getText().contains("Books & Music & Film"));
        productsPages.booksMusicFilmCheckBox.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //  Kullanici Catagries sekmesinden urun katagorisi olarak Cosmetics&Personal Care  seceneginin oldugunu dogrular
        //  Kullanici Catagries sekmesinden urun katagorisi olarak Cosmetics&Personal secenegini secer
        ReusableMethods.waitFor(1);
        Assert.assertTrue(productsPages.cosmeticstext.isDisplayed());
        Assert.assertTrue(productsPages.cosmeticstext.getText().contains("Cosmetics&Personal Care"));
        productsPages.cosmeticsCheckBox.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //  Kullanici Catagries sekmesinden urun katagorisi olarak Fashion&Clothing seceneginin oldugunu dogrular
        //  Kullanici Catagries sekmesinden urun katagorisi olarak Fashion&Clothing secenegini secer
        ReusableMethods.waitFor(1);
        Assert.assertTrue(productsPages.fashionClothingtext.isDisplayed());
        Assert.assertTrue(productsPages.fashionClothingtext.getText().contains("Fashion&Clothing"));
        productsPages.fashionClothingCheckBox.click();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();


        //  Kullanici Catagries sekmesinden urun katagorisi olarak Toys & Games seceneginin oldugunu dogrular
        //  Kullanici Catagries sekmesinden urun katagorisi olarak Toys & Games secenegini secer
        ReusableMethods.waitFor(1);
        Assert.assertTrue(productsPages.toysGamestext.isDisplayed());
        Assert.assertTrue(productsPages.toysGamestext.getText().contains("Toys & Games"));
        productsPages.toysGamesCheckBox.click();
        actions.sendKeys(Keys.PAGE_UP).perform();


        //  Kullanici Catagries sekmesinden urun katagorisi olarak New Arrivals seceneginin oldugunu dogrular
        //  Kullanici Catagries sekmesinden urun katagorisi olarak New Arrivals  secenegini secer
        ReusableMethods.waitFor(1);
        Assert.assertTrue(productsPages.newArrivalstext.isDisplayed());
        Assert.assertTrue(productsPages.newArrivalstext.getText().contains("New Arrivals"));
        productsPages.newArrivalsCheckBox.click();
        extentTest.info("Store Manager olarak Urunler katagorisinden Besin takviyeleri ,Cok satanlar, Elektrik & Elektronik,Home&Life ,Discounted,  Books & Music & Film , Cosmetics&Personal,Fashion&Clothing, Toys & Games,New Arrivals  katagorilerini   gorur ve secer");


        //  Kullanici sayfayi kapatir
        ReusableMethods.waitFor(3);
        Driver.closeDriver();


    }
}
