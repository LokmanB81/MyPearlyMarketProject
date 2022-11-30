package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PearlyMarketPages {

    public PearlyMarketPages(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//h2[text()='My Account']")
    public WebElement myAccountSayfasi;

    @FindBy(xpath ="(//*[text()='My Account'])[2]")
    public WebElement myAccountButton;

    @FindBy(xpath="(//*[text()='Sign In'])[1]")
    public WebElement SignIn;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement username;


    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@name='login']")
    public WebElement submitbutton;

    @FindBy(xpath = "//*[@class='col-md-4 col-sm-6 col-12 m-b-md mb-4']")
    public List<WebElement> orders;

    @FindBy (xpath = "//li")
    public List<WebElement> storemanager;

}
