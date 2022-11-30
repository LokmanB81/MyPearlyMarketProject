package tests.US05;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPages;
import pages.ProductsPages;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.List;

public class TC03 extends TestBaseRapor {

    ProductsPages productsPages=new ProductsPages();
    PearlyMarketPages pearlyMarketpages =new PearlyMarketPages();
    Actions actions =new Actions(Driver.getDriver());
    JavascriptExecutor jse =(JavascriptExecutor) Driver.getDriver();

    @Test(groups = "smoke")
    public void US05_TC03_UrunEkleme() throws InterruptedException {

        extentTest = extentReports.createTest("US05 Vendor kullanıcı store manager olarak yeni ürünler ekleyebilmeli",
                "TC03_Store Manager olarak product title ,Price($) , Sale Price ($), Resim,Galery,Catagories ve " +
                        " Product brands seçeneklerini ait alanları doldurup yeni ürün ekleyebilmeli");


        //  Kullanici "https://pearlymarket.com/" Url'ine gider
        //  Kullanici Vendor hesabi ile giriş yapmak icin Sign In 'e  tiklar
        Driver.getDriver().get("https://pearlymarket.com/");
        jse.executeScript("arguments[0].click();", pearlyMarketpages.SignIn);
        ///productsPages.singIn.click();

        //  Kullanici gecerli  bir email , sifre  girer ve Sing İn Butonuna tiklar
        productsPages.username.sendKeys("kubraesra27@hotmail.com");
        productsPages.password.sendKeys("Esrakubra2!");
        productsPages.signInButton.click();

        //  Kullanici ana sayfada My Account linkine tiklar
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.waitFor(1);
        jse.executeScript("arguments[0].click();", productsPages.myAccount);
        //productsPages.myAccount.click();
        extentTest.info("Vendor kullanıcı geçerli username ve şifre ile sign in olup my account sayfasına ulaşabildi");

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

        //   Kullanici product title kutusuna tiklar
        //   Kullanici product title kutusuna urun ismi  girisi yapar
        productsPages.productTitle.click();
        actions.sendKeys("Kalem").perform();

        //   Kullanici acilan Add Product ekranında Price ($) seceneginin oldugunu dogrular
        //   Kullanici Price ($) kutusuna urun satis fiyatini girer
        Assert.assertTrue(productsPages.price$.isDisplayed());
        Assert.assertTrue(productsPages.price$.getText().contains("Price ($)"));
        productsPages.priceSearchBox.click();
        actions.sendKeys("10").perform();

        //   Kullanici acilan Add Product ekranında Sale Price ($) seceneginin oldugunu dogrular
        //   Kullanici Sale Price ($)  kutusuna urun indirimli satis fiyatini girer
        Assert.assertTrue(productsPages.salePrice$.isDisplayed());
        Assert.assertTrue(productsPages.salePrice$.getText().contains("Sale Price ($)"));
        productsPages.salePriceSearchBox.click();
        actions.sendKeys("8").perform();

        //   Kullanici resim eklemek icin Bos Cikan Buyuk Resim Ekraninin üstüne tiklar
        productsPages.featuredImg.click();

        //   Kullanici  Choose image pencersinden Media Library sekmesine tiklar
        productsPages.mediaLibraryIlk.click();
        ReusableMethods.waitFor(1);

        //   Kullanici acilan ekranda bulunan resimlerden istedigi resmi secer ve tiklar.
        productsPages.imgClick1.click();

        //   Kullanici  Select  butonuna tiklar
        productsPages.select.click();

        //   Kullanici resim eklemek icin Bos Cikan Kucuk  Resim Ekranina  tiklar
        ReusableMethods.waitFor(1);
        productsPages.galeryImg.click();

        //   Kullanici  Choose image pencersinden Media Library sekmesine tiklar
        productsPages.mediaLibraryIkinci.click();

        //   Kullanici acilan pencerede eklemek istedigi resmi secer
        ReusableMethods.waitFor(1);
        productsPages.imgClick2.click();

        //   Kullanici sectigi resmi eklemek icin Add To Galery butonuna tiklar olusturur
        productsPages.addToGallery.click();

        //  Kullanici Categories sekmesinin oldugunu dogrular
        //   Kullanici Catagries sekmesinden herhangi bir katagori secer
        ReusableMethods.waitFor(1);
       // Assert.assertTrue(productsPages.categories.isDisplayed());
       // Assert.assertTrue(productsPages.categories.getText().contains("Categories*"));
       // Thread.sleep(1000);
        productsPages.bestSellerCheckBox.click();
        Thread.sleep(1000);


        //   Kullanici Product brands sekmesinin oldugunu dogrular
        //   Kullanici Product brands sekmesinden herhangi bir brands secer
       // Assert.assertTrue(productsPages.pruductBrands.isDisplayed());
       // Assert.assertTrue(productsPages.pruductBrands.getText().contains("Product brands"));
        jse.executeScript("arguments[0].click();", productsPages.adidasCheckBox);
      //  ReusableMethods.jsclick(productsPages.adidasCheckBox);
        ReusableMethods.waitFor(1);


        //   Kullanici Submit Butonuna  Tiklar
        ReusableMethods.jsclick(productsPages.submit);

        //   Kullanici "Product Successfully Published."mesajı ile istenilen bilgileri girdiginde Submit  yapabildigini dogrular
        ReusableMethods.waitForVisibility(productsPages.editProductText,10);
        Assert.assertTrue(productsPages.editProductText.isDisplayed());
        extentTest.info("Store Manager olarak product title ,Price($) , Sale Price ($), Resim,Galery,Catagories ve  " +
                "Product brands seçeneklerini ait alanları doldurup yeni ürün ekleyebildi");
        Thread.sleep(1000);
        jse.executeScript("arguments[0].click();", productsPages.viewsLink);

        List<String> windowHandles=new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowHandles.get(1));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("urun/kalem"));

        extentTest.pass("Vendor kullanıcı store manager olarak siteye ekledigi ürünün sitede yayınlandığını gördü");




        //   Kullanici sayfayi kapatir
        ReusableMethods.waitFor(3);
      Driver.closeDriver();

    }
}
