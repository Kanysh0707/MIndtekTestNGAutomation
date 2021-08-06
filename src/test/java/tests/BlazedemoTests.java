package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BlazedemoFlightsPage;
import pages.BlazedemoHomePage;
import utilities.ConfigReader;
import utilities.TestBase;

import java.util.List;

public class BlazedemoTests extends TestBase {

    @Test(groups = {"regression"})
    public void test1() {
        BlazedemoHomePage blazeDemoHomePage = new BlazedemoHomePage();
        BlazedemoFlightsPage blazedemoFlightsPage = new BlazedemoFlightsPage();

        driver.get(ConfigReader.getProperty("BlazedemoURL"));
        blazeDemoHomePage.findFlightsButton.click();
        // validate all prices
        List<WebElement> prices = blazedemoFlightsPage.prices;
        for (WebElement element : prices) {
            String priceStr = element.getText();
            priceStr = priceStr.substring(1);
            double priceDoule = Double.parseDouble(priceStr);
            Assert.assertTrue(priceDoule < 1000);
        }
    }

    @Test(groups = {"regression"})
    public void test2() {
        BlazedemoHomePage blazeDemoHomePage = new BlazedemoHomePage();
        BlazedemoFlightsPage blazedemoFlightsPage = new BlazedemoFlightsPage();

        driver.get(ConfigReader.getProperty("BlazedemoURL"));
        Select select = new Select(blazeDemoHomePage.fromCityDropdown);
        select.selectByValue("Boston");
        select = new Select(blazeDemoHomePage.toCityDropdown);
        select.selectByValue("London");
        blazeDemoHomePage.findFlightsButton.click();
        String actualText=blazedemoFlightsPage.headerText.getText();
        String expectedText="Flights from Boston to London:";
        Assert.assertEquals(actualText,expectedText);

    }

}
