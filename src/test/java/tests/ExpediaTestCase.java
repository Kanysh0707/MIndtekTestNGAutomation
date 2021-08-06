package tests;

import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.ExpediaHomePage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.TestBase;

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

        Thread.sleep(3000);
        //expediaHomePage.help.click();
        System.out.println(driver.getTitle());



    }
}
