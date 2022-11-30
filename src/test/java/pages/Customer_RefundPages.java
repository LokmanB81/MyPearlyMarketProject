package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Customer_RefundPages {

    public Customer_RefundPages() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy (xpath = "//*[text()='Sign In']")
    public WebElement signIn;

    @FindBy (xpath = "//*[@id='username']")
    public WebElement usarnameBar;

    @FindBy (xpath = "//*[@id='password']")
    public WebElement passwordBar;

    @FindBy (xpath = "//*[@name='login']")
    public WebElement login;

    @FindBy (xpath = "(//*[@href='https://pearlymarket.com/my-account-2/'])[1]")
    public WebElement myAccount;

    @FindBy (xpath = "//*[@href='https://pearlymarket.com/store-manager/']")
    public WebElement storeManager;

    @FindBy (xpath = "(//span[@class='text'])[7]")
    public WebElement customer;

    @FindBy (xpath = "(//*[@href='https://pearlymarket.com/store-manager/customers-manage/'])[2]")
    public WebElement addNew;

    @FindBy (xpath = "//input[@id='user_name']")
    public WebElement addCustomerUserName;

    @FindBy (xpath = "//input[@id='user_email']")
    public WebElement addCustomerUserEmail;

    @FindBy (xpath = "//input[@id='first_name']")
    public WebElement addCustomerFirstName;

    @FindBy (xpath = "//input[@id='last_name']")
    public WebElement addCustomerLastName;

    @FindBy (xpath = "//input[@id='bfirst_name']")
    public WebElement billingFirstName;

    @FindBy (xpath = "//input[@id='blast_name']")
    public WebElement billingLastName;

    @FindBy (xpath = "//input[@id='bcompany_name']")
    public WebElement billingCompanyName;

    @FindBy (xpath = "//input[@id='bphone']")
    public WebElement billingPhone;

    @FindBy (xpath = "//input[@id='baddr_1']")
    public WebElement billingAdress1;

    @FindBy (xpath = "//input[@id='baddr_2']")
    public WebElement billingAdress2;

    @FindBy (xpath = "//select[@id='bcountry']")
    public WebElement billingSelectCountry;

    @FindBy (xpath = "//*[@title='Canada']")
    public WebElement billingCountry;

    @FindBy (xpath = "//input[@id='bcity']")
    public WebElement billingCity;

    @FindBy (xpath = "//input[@id='bstate']")
    public WebElement billingState;

    @FindBy (xpath = "//input[@id='bzip']")
    public WebElement billingZipCode;

    @FindBy (xpath = "//*[@id='same_as_billing']")
    public WebElement shippingSameAsBillingCheckBox;

    @FindBy (xpath = "//input[@id='sfirst_name']")
    public WebElement shippingFirstName;

    @FindBy (xpath = "//input[@id='slast_name']")
    public WebElement shippingLastName;

    @FindBy (xpath = "//input[@id='scompany_name']")
    public WebElement shippingCompanyName;

    @FindBy (xpath = "//input[@id='saddr_1']")
    public WebElement shippingAdress1;

    @FindBy (xpath = "//input[@id='saddr_2']")
    public WebElement shippingAdress2;

    @FindBy (xpath = "//*[@id='select2-scountry-container']")
    public WebElement shippingSelectCountry;

    @FindBy (xpath = "//input[@id='scity']")
    public WebElement shippingCity;

    @FindBy (xpath = "//input[@id='sstate']")
    public WebElement shippingState;

    @FindBy (xpath = "//input[@id='szip']")
    public WebElement shippingZipCode;

    @FindBy (xpath = "//*[@id='wcfm_customer_submit_button']")
    public WebElement customerPageSubmitButton;

    @FindBy (xpath = "//h2[text()='Edit Customer']")
    public WebElement editCustomerText;

    @FindBy (xpath = "//*[contains(text(), 'Customer Successfully Saved.')]")
    public WebElement customerSuccessfullySavedText;

    @FindBy (xpath = "//thead//th")
    public List<WebElement> customerTableHeads;

    @FindBy (xpath = "//tbody//td[1]")
    public List<WebElement> customerTableNameColumn;

    @FindBy (xpath = "//tbody//td[2]")
    public List<WebElement> customerTableUserNameColumn;

    @FindBy (xpath = "//tbody//td[3]")
    public List<WebElement> customerTableEmailColumn;

    @FindBy (xpath = "//tbody//td[4]")
    public List<WebElement> customerTableLocationColumn;

    @FindBy (xpath = "//tbody//td[5]")
    public List<WebElement> customerTableOrdersColumn;

    @FindBy (xpath = "//tbody//td[6]")
    public List<WebElement> customerTableMoneySpentColumn;

    @FindBy (xpath = "//tbody//td[7]")
    public List<WebElement> customerTableLastOrderColumn;

    @FindBy (xpath = "//*[@class='dt-button buttons-pdf buttons-html5']")
    public WebElement customerDataPdfDownload;

    @FindBy (xpath = "//*[@class='dt-button buttons-excel buttons-html5']")
    public WebElement customerDataExcelDownload;

    @FindBy (xpath = "//*[@class='dt-button buttons-csv buttons-html5']")
    public WebElement customerDataCsvDownload;

    @FindBy (xpath = "//*[text()='Manage Customers']")
    public WebElement manageCustomerText;

}
