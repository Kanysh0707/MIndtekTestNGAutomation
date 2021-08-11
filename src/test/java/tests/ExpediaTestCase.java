package tests;

import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ExpediaHomePage;
import pages.ExpediaSupportPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ExpediaTestCase extends TestBase {
    @Test
    public void test1() {
        driver.get(ConfigReader.getProperty("ExpediaAppURL"));
        ExpediaHomePage expediaHomePage = new ExpediaHomePage();
        expediaHomePage.flightsTab.click();
        expediaHomePage.oneWayButton.click();
        expediaHomePage.leavingFromButton.sendKeys("Chicago (ORD - O'Hare Intl.)" + Keys.ENTER);
        expediaHomePage.goingToButton.sendKeys("Paris" + Keys.ENTER);
        expediaHomePage.departingDate.click();
        expediaHomePage.done.click();
        expediaHomePage.searchButton.click();

    }

    @Test
    public void test3() throws InterruptedException {
        driver.get(ConfigReader.getProperty("ExpediaAppURL"));
        ExpediaHomePage expediaHomePage = new ExpediaHomePage();
        ExpediaSupportPage expediaSupportPage=new ExpediaSupportPage();
        expediaHomePage.supportButton.click();
        Thread.sleep(2000);
        WebElement frameElement=driver.findElement(By.tagName("iframe"));
        BrowserUtils.waitElementToBeVisible(frameElement);
        driver.switchTo().frame(frameElement);
        expediaSupportPage.helpButton.click();
        String expectedMessage="Chat with Virtual Agent";
        Thread.sleep(2000);
        String actualMessage=expediaSupportPage.title.getText();
        Assert.assertEquals(actualMessage,expectedMessage);


    }

}
