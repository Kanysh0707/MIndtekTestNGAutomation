package tests;

import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ExpediaHomePage;
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
        Thread.sleep(3000);
        ExpediaHomePage expediaHomePage = new ExpediaHomePage();
        //expediaHomePage.supportButton.click();

       // expediaHomePage.helpButton.click();

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);

        WebElement element1= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cpce-vac-launch\"]/div/button")));
driver.findElement(By.xpath("//*[@id=\"cpce-vac-launch\"]/div/button")).click();

    }
}
