package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.StoreAppCreateAccountPage;
import pages.StoreAppHomePage;
import pages.StoreAppLoginPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.DataUtils;
import utilities.TestBase;

import java.io.IOException;
import java.util.Random;

public class StoreRegisterFunctionalityTests extends TestBase {
    String email;
    String password;
    //Data Driven Testing->testing functionality with diff.sets

    @DataProvider(name = "signUpDataProvider")
    public static Object[][] testData() {
        Object[][] data = new Object[][]{
                {"John", "Doe", "123456789", DataUtils.generateRandomNumber(30) + "", "1", "2021", "123 Clark St.", "Chicago", "13", "60659", "21", "1234567890"},
                {"Kim", "Yi", "abcdlmn", "1", "12", "1980", "2 MyRoad st.", "New York", "32", "54321", "21", "987654321"},
                {"Patel", "Harsh", "efg123456", "1", "12", "1980", "2 MyRoad st.", "New York", "32", "54321", "21", "987654321"}
        };
        return data;

    }


    @Test(dataProvider = "signUpDataProvider", groups = {"regression", "smoke"})
    public void test1(String firstName, String lastName, String password, String day, String month, String year, String address, String city,
                      String state, String zipCode, String country, String phoneNumber) throws IOException {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppLoginPage storeAppLoginPage = new StoreAppLoginPage();
        StoreAppCreateAccountPage storeAppCreateAccountPage = new StoreAppCreateAccountPage();

        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.loginButton.click();
        email = DataUtils.generateEmail();
        storeAppLoginPage.emailBox.sendKeys(email);
        storeAppLoginPage.submitButton.click();
        storeAppCreateAccountPage.gender.click();
        storeAppCreateAccountPage.FirstNameBox.sendKeys(firstName);
        storeAppCreateAccountPage.LastNameBox.sendKeys(lastName);
        storeAppCreateAccountPage.PasswordBox.sendKeys(password);
        this.password = password;

        BrowserUtils.selectByValue(storeAppCreateAccountPage.daysBox, day);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.monthsBox, month);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.yearsBox, year);

        storeAppCreateAccountPage.address1Box.sendKeys(address);
        storeAppCreateAccountPage.cityBox.sendKeys(city);

        BrowserUtils.selectByValue(storeAppCreateAccountPage.stateBox, state);
        storeAppCreateAccountPage.postcodeBox.sendKeys(zipCode);
        BrowserUtils.selectByValue(storeAppCreateAccountPage.countryBox, country);
        storeAppCreateAccountPage.phonemobileBox.sendKeys(phoneNumber);
        storeAppCreateAccountPage.registerButton.click();
        BrowserUtils.takeScreenshot("SignUpValidation");

        String actualTitle = driver.getTitle();
        String expectedTitle = "My account - My Store";
        Assert.assertEquals(actualTitle, expectedTitle, "Actual title " + actualTitle + " didn't match with expected title " + expectedTitle);

    }

    // Login functionality
    @Test(dependsOnMethods = {"test1"}, groups={"regression","smoke"})
    public void test2() throws IOException {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppLoginPage storeAppLoginPage = new StoreAppLoginPage();
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.loginButton.click();
        storeAppLoginPage.loginEmailBox.sendKeys(email);
        storeAppLoginPage.loginPasswordBox.sendKeys(password);
        storeAppLoginPage.LoginButton.click();
        BrowserUtils.takeScreenshot("LoginValidation");
        String actualTitle = driver.getTitle();
        String expectedTitle = "My account - My Store";
        Assert.assertEquals(actualTitle, expectedTitle, "Title for log in did not match");

    }

}