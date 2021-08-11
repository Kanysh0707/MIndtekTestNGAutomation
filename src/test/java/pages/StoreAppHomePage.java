package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class StoreAppHomePage {

    public StoreAppHomePage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"contact-link\"]/a")
    public WebElement contactUsButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    public WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[1]/span")
    public List<WebElement> prices;
    @FindBy(xpath = "//ul[@id='homefeatured']//a[@data-id-product='1']")
    public WebElement addCartItem1;
    @FindBy(xpath = "//div[@class='layer_cart_product col-xs-12 col-md-6']//h2")
    public WebElement addCartSuccessMessage;
    @FindBy(xpath = "//ul[@id='homefeatured']/li")
    public WebElement item1;
    @FindBy(id = "layer_cart_product_quantity")
    public WebElement quantity;

    @FindBy(id = "layer_cart_product_price")
    public WebElement totalPrice;

    @FindBy(xpath = "//a[@class='btn btn-default button button-medium']")
    public WebElement proceedToCheckOut;

    @FindBy(xpath = "//ul[@id='homefeatured']/li[2]")
    public WebElement item2;

    @FindBy(xpath = "//ul[@id='homefeatured']//a[@data-id-product='2']")
    public WebElement addCartItem2;

    @FindBy(xpath="//span[@title='Close window']")
    public WebElement closeButton;




}