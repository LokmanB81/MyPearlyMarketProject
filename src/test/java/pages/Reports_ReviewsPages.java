package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.Arrays;
import java.util.List;

public class Reports_ReviewsPages {
    public Reports_ReviewsPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement userNameBox;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@name='login']")
    public WebElement loginSignIn;

    @FindBy(xpath = "(//*[@href='https://pearlymarket.com/my-account-2/'])[1]")
    public WebElement myAccountLink;

    @FindBy(xpath = "//*[@href='https://pearlymarket.com/store-manager/']")
    public WebElement storeManagerLink;

    @FindBy(xpath = "(//h2)[1]")
    public WebElement myAccountText;

    @FindBy(xpath = "//div/a[@href='https://pearlymarket.com/store-manager/reviews/']")
    public WebElement reviewsLink;

    @FindBy(xpath = "//thead/tr/th")
    public List<WebElement> reviewsTableThead;

    @FindBy(xpath = "//*[@id='add_new_product_dashboard']")
    public WebElement productReviewsButton;

    @FindBy(xpath = "//tbody/tr/td")
    public List<WebElement> productReviewsTables;

    @FindBy(xpath = "//*[@href='https://pearlymarket.com/store-manager/reports-sales-by-date/']")
    public WebElement reportsLink;

    @FindBy(xpath = "//li[text()='Reports - Sales by Date']")
    public WebElement reportsPageControlText;
    @FindBy(xpath = "//*[@href='/store-manager/reports-sales-by-date/?range=year']")
    public WebElement reportsYearButton;
    @FindBy(xpath = "//*[@href='/store-manager/reports-sales-by-date/?range=last_month']")
    public WebElement reportsLastMonthButton;
    @FindBy(xpath = "//*[@href='/store-manager/reports-sales-by-date/?range=month']")
    public WebElement reportsThisMonthButton;
    @FindBy(xpath = "//*[@href='/store-manager/reports-sales-by-date/?range=7day']")
    public WebElement reportsLastDaysButton;
    @FindBy(xpath = "//*[@name='wcfm-date-range']")
    public WebElement reportsDateChooseBox;

    @FindBy(xpath = "//*[@class='wcfm-page-heading-text']")
    public WebElement reportsPageTableHeadingText;

    @FindBy(xpath = "//*[@id='chart-placeholder-canvas']")
    public WebElement reportsPageTable;

    @FindBy(xpath = "//tbody/tr[4]/td")
    public List<WebElement> calendarDays;

    @FindBy(xpath = "(//*[text()='Orders'])[1]")
    public WebElement orderButton;

    @FindBy(xpath = "(//*[text()='Downloads'])[1]")
    public WebElement downloadsButton;

    @FindBy(xpath = "(//*[text()='Addresses'])[1]")
    public WebElement addressesButton;

    @FindBy(xpath = "(//*[text()='Account details'])[1]")
    public WebElement accountDetailsButton;

    @FindBy(xpath = "//thead/tr")
    public WebElement ordersTable;

    @FindBy(xpath = "(//*[text()='Downloads'])[3]")
    public WebElement downloadPageControlText;

    @FindBy(xpath = "//tbody/tr/td")
    public List<WebElement> adresTableDatas;

    @FindBy(xpath = "//*[@type='text']")
    public List<WebElement> accountDetailsNames;

    @FindBy(xpath = "//*[@id='account_email']")
    public WebElement accountDetailEmail;

    @FindBy(xpath = "//*[@autocomplete='off']")
    public List<WebElement> accountDetailpassword;

    @FindBy(xpath = "//*[@name='save_account_details']")
    public WebElement saveChangesButton;

   // @FindBy(xpath = "//*[contains(text(), 'Account details changed successfully.']")
  //  public WebElement succesfullText;

    @FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement succesfullText;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signOutButton;

    @FindBy(xpath = "//*[@class='icon-box-icon icon-logout']")
    public WebElement logOutButton;


    public  List<String> expectedTableHead= Arrays.asList("Author","Comment","Rating","Dated");

}
