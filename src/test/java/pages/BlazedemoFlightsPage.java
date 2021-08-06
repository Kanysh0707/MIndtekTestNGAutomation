package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class BlazedemoFlightsPage {

        public BlazedemoFlightsPage(){
            WebDriver driver= Driver.getDriver();
            PageFactory.initElements(driver,this);
        }
    @FindBy(xpath = "//tbody//td[6]")
    public List<WebElement> prices;
        @FindBy(xpath = "//div[2]/h3")
    public WebElement headerText;

}
