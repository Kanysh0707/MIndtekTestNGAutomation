package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ExpediaHomePage {
    public ExpediaHomePage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
@FindBy(xpath="//a[@href='?pwaLob=wizard-flight-pwa']")
    public WebElement flightsTab;

    @FindBy(xpath="//*[@id=\"uitk-tabs-button-container\"]/div/li[2]/a/span")
    public WebElement oneWayButton;

    @FindBy (xpath="//button[@aria-label='Leaving from']")
    public WebElement leavingFromButton;

    @FindBy(xpath="//button[@aria-label='Going to']")
    public WebElement goingToButton;

    @FindBy(id="d1-btn")
    public WebElement departingDate;

    @FindBy(xpath = "//button[@aria-label='Aug 28, 2021 selected, current check in date.']")
    public WebElement getDepartingDate;

    @FindBy(xpath="//*[@id=\"wizard-flight-pwa-1\"]/div[3]/div[2]/button")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"wizard-flight-tab-oneway\"]/div[2]/div[2]/div/div/div/div/div[2]/div/div[3]/button")
    public WebElement done;

    @FindBy(xpath = "//div[@class='uitk-text uitk-type-400 uitk-type-medium uitk-flex-item']")
    public WebElement filterButton;

    @FindBy(id = "stops-1")
    public WebElement oneStopButton;

    @FindBy(xpath = "//button[@data-test-id='sort-filter-done-button']")
    public WebElement doneButton;



    @FindBy(xpath="//div[contains(text(),'Support')]")
    public WebElement supportButton;
@FindBy(xpath="//div[@class='fab-container']")
    public WebElement help1;




}