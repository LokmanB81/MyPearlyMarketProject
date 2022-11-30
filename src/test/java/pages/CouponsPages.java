package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CouponsPages {
    public CouponsPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement signinButton;

    @FindBy(xpath = "//a[.='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "(//span[@class='text'])[6]")
    public WebElement couponsButton;

    @FindBy(xpath = "//a[@id='add_new_coupon_dashboard']")
    public WebElement addNewButton;

    @FindBy(xpath = "//input[@id='title']")
    public WebElement codeBox;

    @FindBy(xpath = "//textarea[@id='description']")
    public WebElement descriptionBox;

    @FindBy(xpath = "//select[@id='discount_type']")
    public WebElement discountType;

    @FindBy(xpath = "//input[@id='coupon_amount']")
    public WebElement couponAmount;

    @FindBy(xpath = "//input[@id='expiry_date']")
    public WebElement expiryDateBox;

    @FindBy(xpath = "//input[@id='free_shipping']")
    public WebElement freeShippingBox;

    @FindBy(xpath = "//input[@id='show_on_store']")
    public WebElement showOnStoreBox;

    @FindBy(xpath = "(//td[@class='sorting_1'])[1]")
    public WebElement lastSavedCoupon;

    @FindBy(xpath = "(//span[.='Fixed product discount'])[1]")
    public WebElement fixedProductDiscountYazisi;

    @FindBy(xpath = "(//span[.='Percentage discount'])[1]")
    public WebElement percentageDiscountYazisi;

    @FindBy (xpath = "//*[contains(text(), 'Coupon Successfully Published.')]")
    public WebElement popUpMessageHappy;

    @FindBy(xpath = "//div[@id='coupons_manage_restriction']")
    public WebElement restrictionButton;

    @FindBy(xpath = "//input[@id='minimum_amount']")
    public WebElement minimumSpendBox;

    @FindBy(xpath = "//input[@id='maximum_amount']")
    public WebElement maximumSpendBox;

    @FindBy(xpath = "//input[@id='individual_use']")
    public WebElement individualUseOnlyBox;

    @FindBy(xpath = "//input[@id='exclude_sale_items']")
    public WebElement excludeSaleItemsBox;

    @FindBy(xpath = "(//input[@class='select2-search__field'])[1]")
    public WebElement productsBox;

    @FindBy(xpath = "") // locate problem
    public WebElement excludeProductsBox;

    @FindBy(xpath = "//input[@id='customer_email']")
    public WebElement emailRestrictionsBox;

    @FindBy(xpath = "//div[@id='coupons_manage_limit']")
    public WebElement limitButton;

    @FindBy(xpath = "//input[@id='usage_limit']")
    public WebElement usageLimitperCouponBox;

    @FindBy(xpath = "//input[@id='limit_usage_to_x_items']")
    public WebElement limitUsageToXItemsBox;

    @FindBy(xpath = "//input[@id='limit_usage_to_x_items']")
    public WebElement usageLimitPerUserBox;

    @FindBy(xpath = "//input[@id='wcfm_coupon_manager_submit_button']")
    public WebElement submitButton;






}
