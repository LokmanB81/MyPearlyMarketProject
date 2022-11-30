package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ProductsPages {

    public ProductsPages() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    //kubraesra27@hotmail.com Esrakubra2!

    // Giris Login kısmı

    @FindBy(xpath = "//a[@class='login inline-type']")
    public WebElement singIn;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@class='woocommerce-button button woocommerce-form-login__submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//a[text()='My Account']")
    public WebElement myAccount;

    @FindBy(xpath = "//h2[@class='page-title']")
    public WebElement myAccountText;

    @FindBy(xpath = "//a[@href='https://pearlymarket.com/store-manager/']")
    public WebElement storeManager;

    @FindBy(xpath = "//h2[@class='page-title']")
    public WebElement storeManagerText;


    // Products sekmesi icin

    @FindBy(xpath = "//div[@class='wcfm_menu_items wcfm_menu_wcfm-products']")
    public WebElement products;

    @FindBy(xpath = "//span[@class='wcfm-page-heading-text']")
    public WebElement productsText;

    @FindBy(xpath = "(//th[@class='sorting_disabled'])[3]")
    public WebElement status;

    @FindBy(xpath = "(//th[@class='sorting_disabled'])[4]")
    public WebElement stok;

    @FindBy(xpath = "(//*[@class='sorting'])[2]")
    public WebElement price;

    @FindBy(xpath = "(//*[@class='sorting'])[4]")
    public WebElement date;

    // Add New Ekrani

    @FindBy(xpath = "//span[text()='Add New']")
    public WebElement addNew;

    @FindBy(xpath = "//*[text()='Add Product']")
    public WebElement addProduct;

    @FindBy(xpath = "//p[text()='Virtual']")
    public WebElement virtual;

    @FindBy(xpath = "//input[@id='is_virtual']")
    public WebElement virtualCheckBox;

    @FindBy(xpath = "//p[text()='Downloadable']")
    public WebElement downloadable;

    @FindBy(xpath = "//input[@id='is_downloadable']")
    public WebElement downloadableCheckBox;

    @FindBy(xpath = "//input[@id='pro_title']")
    public WebElement productTitle;

    @FindBy(xpath = "(//*[text()='Price ($)'])[1]")
    public WebElement price$;

    @FindBy(xpath = "//input[@id='regular_price']")
    public WebElement priceSearchBox;

    @FindBy(xpath = "//*[text()='Sale Price ($)']")
    public WebElement salePrice$;

    @FindBy(xpath = "//input[@id='sale_price']")
    public WebElement salePriceSearchBox;

    @FindBy(xpath = "//img[@id='featured_img_display']")
    public WebElement featuredImg;

    @FindBy(xpath = "//button[@id='menu-item-browse']")
    public WebElement mediaLibraryIlk;

    @FindBy(xpath = "(//*[@class='thumbnail'])[1]")
    public WebElement imgClick1;

    @FindBy(xpath = "//*[@class='button media-button button-primary button-large media-button-select']")
    public WebElement select;

    @FindBy(xpath = "//img[@id='gallery_img_gimage_0_display']")
    public WebElement galeryImg;

    @FindBy(xpath = "(//button[@id='menu-item-browse'])[2]")
    public WebElement mediaLibraryIkinci;

    @FindBy(xpath = "(//*[@class='thumbnail'])[5]")
    public WebElement imgClick2;

    @FindBy(xpath = "(//button[text()='Add to Gallery'])[2]")
    public WebElement addToGallery;

    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_brand '])[1]")
    public WebElement adidasCheckBox;


    @FindBy(xpath = "//input[@id='wcfm_products_simple_submit_button']")
    public WebElement submit;

    @FindBy (xpath = "//*[contains(text(), 'Product Successfully Published.')]")
    public WebElement popUpMessageHappy;

    @FindBy (xpath = "//*[@class='wcicon-status-cancelled']")
    public WebElement popUpMessageNegative;


    @FindBy(xpath = "(//*[text()='Short Description'])[1]")
    public WebElement shortDescription;

    @FindBy(xpath = "//iframe")
    public List<WebElement> iframe;

    @FindBy(xpath = "(//*[@id='tinymce'])[1]")
    public List<WebElement> shortDescriptionBox;

    @FindBy(xpath = "(//*[text()='Description'])[1]")
    public WebElement description;



    //Categories CheckBox kutusu icin

    @FindBy(xpath = "(//*[text()='Categories'])[1]")
    public WebElement categories;

    @FindBy(xpath = "//*[text()='Besin takviyeleri']")
    public WebElement besinTakviyeleriText;

    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_cat '])[10]")
    public WebElement bestSellerCheckBox;

    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_cat '])[9]")
    public WebElement besinTakviyeleriCheckBox;

    @FindBy(xpath = "(//*[text()='Cok satanlar'])[1]")
    public WebElement cokSatanlarText;

    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_cat '])[17]")
    public WebElement cokSatanlarCheckBox;

    @FindBy(xpath = "(//*[text()='Elektrik & Elektronik'])[2]")
    public WebElement elektrikElektroniktext;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[30]")
    public WebElement elektrikElektronikCheckBox;

    @FindBy(xpath = "(//*[text()='Home&Life'])[1]")
    public WebElement homeLifetext;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[64]")
    public WebElement homeLifeCheckBox;

    @FindBy(xpath = "(//*[text()='Discounted'])[1]")
    public WebElement discountedtext;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[20]")
    public WebElement discountedCheckBox;

    @FindBy(xpath = "(//*[text()='Books & Music & Film'])[1]")
    public WebElement booksMusicFilmtext;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[11]")
    public WebElement booksMusicFilmCheckBox;

    @FindBy(xpath = "(//*[text()='Cosmetics&Personal Care'])[1]")
    public WebElement cosmeticstext;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[19]")
    public WebElement cosmeticsCheckBox;


    @FindBy(xpath = "(//*[text()='Fashion&Clothing'])[1]")
    public WebElement fashionClothingtext;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[32]")
    public WebElement fashionClothingCheckBox;

    @FindBy(xpath = "(//*[text()='Toys & Games'])[2]")
    public WebElement toysGamestext;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[94]")
    public WebElement toysGamesCheckBox;


    @FindBy(xpath = "(//*[text()='New Arrivals'])[1]")
    public WebElement newArrivalstext;


    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[81]")
    public WebElement newArrivalsCheckBox;

    @FindBy(xpath = "(//*[@type='checkbox'])[75]")
    public WebElement kirtasiyeChecBox;



    // Pruducst Brands ChechkBox Kutusu için

    @FindBy(xpath = "(//*[text()='Product brands'])[1]")
    public WebElement pruductBrands;


    @FindBy(xpath = "//li[@class='product_cats_checklist_item checklist_item_35']")
    public WebElement elegantAutoGroupText;

    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_brand '])[10]")
    public WebElement elegantAutoGroupCheckBox;


    @FindBy(xpath = "//li[@class='product_cats_checklist_item checklist_item_41']")
    public WebElement greenGrassText;

    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_brand '])[14]")
    public WebElement greenGrassCheckBox;

    @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_46']")
    public WebElement nodeJsText;

    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_brand '])[34]")
    public WebElement nodeJsCheckBox;

    @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_47']")
    public WebElement nS8Text;

    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_brand '])[36]")
    public WebElement nS8CheckBox;

    @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_50']")
    public WebElement redText;

    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_brand '])[49]")
    public WebElement redCheckBox;

    @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_52']")
    public WebElement skysuiteTechText;

    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_brand '])[57]")
    public WebElement skysuiteTechCheckBox;


    @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_55']")
    public WebElement sterlingText;

    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_brand '])[59]")
    public WebElement sterlingCheckBox;

    @FindBy(xpath = "//*[text()='Edit Product']")
    public WebElement editProductText;

    @FindBy(xpath = "//*[@class='wcfmfa fa-eye text_tip']")
    public WebElement viewsLink;










}
