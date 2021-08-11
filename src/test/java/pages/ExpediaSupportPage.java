package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ExpediaSupportPage {
    public ExpediaSupportPage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='fab-container']")
    public WebElement help;
        @FindBy(xpath = "//button[@class='uitk-button uitk-button-small uitk-button-has-text uitk-button-secondary uitk-button-floating launch-button']")
                public WebElement helpButton;
@FindBy(xpath="//*[@id=\"cpce-vac-header-text\"]/h2")
    public WebElement successMess;
@FindBy(xpath = "//header[@aria-label='Chat with Virtual Agent']")
    public WebElement title;

}
